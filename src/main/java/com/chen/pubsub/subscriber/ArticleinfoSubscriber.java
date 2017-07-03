package com.chen.pubsub.subscriber;

import com.chen.email.ArticleinfoEmail;
import com.chen.pojo.Articleinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ryder on 2017/6/30.
 *
 */
public class ArticleinfoSubscriber implements MessageListener {
    private ArticleinfoEmail articleinfoEmail;
    //todo:修改为可自动排序的结构
    private final ConcurrentLinkedQueue<Articleinfo> rows = new ConcurrentLinkedQueue<>();
    private String name;
    private RedisTemplate<Serializable,Serializable> redisTemplate;

    public ArticleinfoSubscriber(ArticleinfoEmail articleinfoEmail, RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.articleinfoEmail = articleinfoEmail;
        this.redisTemplate = redisTemplate;
    }

    public ArticleinfoEmail getArticleinfoEmail() {
        return articleinfoEmail;
    }

    public void setArticleinfoEmail(ArticleinfoEmail articleinfoEmail) {
        this.articleinfoEmail = articleinfoEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        //redis存数据是将数据序列化转为byte[]，获取数据也是byte[]，需要反序列化
        StringRedisSerializer keySerializer = (StringRedisSerializer) redisTemplate.getKeySerializer();
        JdkSerializationRedisSerializer valueSerializer = (JdkSerializationRedisSerializer)redisTemplate.getValueSerializer();
        String channel = keySerializer.deserialize(message.getChannel());
        Articleinfo articleinfo = (Articleinfo)valueSerializer.deserialize(message.getBody());

        //一个存在于section_url中的特殊命令,用来表示发布结束，可以发送邮件了
        if("send_email".equals(articleinfo.getSection_url())){
            System.out.println("发送邮件");
//            articleinfoEmail.init(name);
//            while (true){
//                Articleinfo row = rows.poll();
//                if(row!=null)
//                    articleinfoEmail.add(row);
//                else
//                    break;
//            }
//            articleinfoEmail.send();
        }
        else {
            System.out.println("用户："+name+",在channel："+channel+",收到内容："+articleinfo);
            rows.offer(articleinfo);
        }
    }
}