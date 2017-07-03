package com.chen.pubsub.manager;

import com.chen.pojo.Articleinfo;
import com.chen.pojo.PushRule;
import com.chen.pojo.User;
import com.chen.pubsub.publisher.MessagePublisher;
import com.chen.pubsub.subscriber.ArticleinfoSubscriber;
import com.chen.pubsub.updater.ArticleinfoUpdateManager;
import com.chen.service.PushRuleService;
import com.chen.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by ryder on 2017/6/30.
 *
 */
public class SubManager {
    // todo:log的添加
    private final ConcurrentHashMap<String,ArticleinfoSubscriber> useridToSubscriber = new ConcurrentHashMap<>(); // key为userid
    private final ConcurrentHashMap<String,ChannelTopic> pushruleidToTopic = new ConcurrentHashMap<>();  // key为PushRule的id,在订阅发布中命名为channelName
    private final ConcurrentHashMap<String,PushRule> pushrules = new ConcurrentHashMap<>(); //多加入个key，为了广播的方便
    @Resource
    private RedisMessageListenerContainer redisContainer;
    @Resource
    private RedisTemplate<Serializable,Serializable> redisTemplate;
    @Resource
    private PushRuleService pushRuleService;
    @Resource
    private UserService userService;

    @Resource
    private ArticleinfoUpdateManager articleinfoUpdateManager;

    private SubManager() {
    }

    public ConcurrentHashMap<String,PushRule> getPushrules() {
        return pushrules;
    }

    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        return redisTemplate;
    }

    private void initfunc(){
        List<PushRule> rules = pushRuleService.findPushRule();
        for(PushRule pushRule:rules){
            String channelName = Integer.toString(pushRule.getId());
            pushruleidToTopic.put(channelName,new ChannelTopic(channelName));
            pushrules.put(channelName,pushRule);
            String[] subscribers = pushRule.getSubscribers().trim().split(" "); //订阅者id，为他的userid
            if(!(subscribers.length==1 && "".equals(subscribers[0]))) {
                for (String subscriberId : subscribers) {
                    if (useridToSubscriber.get(subscriberId) != null) {
                        addSubInit(channelName, useridToSubscriber.get(subscriberId));
                    } else {
                        User user = userService.findUserById(Integer.parseInt(subscriberId));
                        ArticleinfoSubscriber newSubscriber = new ArticleinfoSubscriber(user.getUserName(), redisTemplate);//user表格的userName就是邮箱地址
                        useridToSubscriber.put(subscriberId, newSubscriber);
                        addSubInit(channelName, newSubscriber);
                    }
                }
            }
        }
//        在启动时测试订阅发布功能
        Articleinfo articleinfo = new Articleinfo(1,"section","title","titleurl",new Date(),100,"author");
        MessagePublisher messagePublisher = new MessagePublisher(redisTemplate);
        messagePublisher.publishMessage("1",articleinfo);
        messagePublisher.publishMessage("1",MessagePublisher.SEND_EMAIL);

//        在启动时测试生产消费-订阅发布功能
//        try {
//            articleinfoUpdateManager.update();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }

    //从数据库读取的订阅信息，无需再写入数据库
    public void addSubInit (String channelName, ArticleinfoSubscriber subscriber){
        ChannelTopic topic = pushruleidToTopic.get(channelName);
        redisContainer.addMessageListener(subscriber,topic);
        System.out.println("用户:"+subscriber.getName()+",订阅了channel:"+channelName);
    }

    //用户新订阅，写入数据库
    public void addSub (String channelName, ArticleinfoSubscriber subscriber){
        ChannelTopic topic = pushruleidToTopic.get(channelName);
        redisContainer.addMessageListener(subscriber,topic);
        System.out.println("用户:"+subscriber.getName()+",订阅了channel:"+channelName);
        //写入修改
    }
    //用户退订，并写入数据库
    public void removeSub(String channelName, ArticleinfoSubscriber subscriber){
        ChannelTopic topic = new ChannelTopic(channelName);
        redisContainer.removeMessageListener(subscriber,topic);
        System.out.println("用户:"+subscriber.getName()+",退订了channel:"+channelName);
        //写入修改
    }
}
