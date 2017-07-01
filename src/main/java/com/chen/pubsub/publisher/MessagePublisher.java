package com.chen.pubsub.publisher;


import com.chen.pojo.Articleinfo;
import com.chen.pubsub.manager.SubManager;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by ryder on 2017/6/30.
 *
 */
public class MessagePublisher {
    //todo:信息结束,发送邮件命令：send_email
    public static final Articleinfo SEND_EMAIL = new Articleinfo(0,"send_email",null,null,null,null,null);
    private String name;
    private RedisTemplate<Serializable,Serializable> redisTemplate;

    public MessagePublisher(String name, RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.name = name;
        this.redisTemplate = redisTemplate;
    }

    public String getName() {
        return name;
    }
    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        return redisTemplate;
    }

    public void publishMessage(String channel, Serializable msg){
        if(msg == null)
            return;
        redisTemplate.convertAndSend(channel, msg);
    }

}
