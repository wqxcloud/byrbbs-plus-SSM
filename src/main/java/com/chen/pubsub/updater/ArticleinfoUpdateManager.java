package com.chen.pubsub.updater;

import com.chen.pojo.Articleinfo;
import com.chen.pojo.PushRule;
import com.chen.pubsub.manager.SubManager;
import com.chen.pubsub.publisher.MessagePublisher;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.concurrent.*;

/**
 * Created by ryder on 2017/7/2.
 *
 */
public class ArticleinfoUpdateManager {
    @Resource
    private SubManager subManager;
    private ConcurrentLinkedQueue<Articleinfo> queue = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<String,PushRule> pushRules = null;
    private Producer producer = null;
    private int THREAD_SIZE = 10;
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(THREAD_SIZE);

    private void init(){
        pushRules = subManager.getPushrules();
        producer = new Producer(queue);
    }
    //定时执行此方法
    public void update() throws Exception{
        producer.run();
        for(int i=0;i<1;i++) {
            fixedThreadPool.execute(new Consumer(queue,pushRules,new MessagePublisher(subManager.getRedisTemplate())));
        }
        //调用shutdown()时，ExecutorService 并不会马上关闭，而是不再接收新的任务
        //所以，在调用 shutdown() 方法之前提交到 ExecutorService 的任务都会执行
        fixedThreadPool.shutdown();
        while(true){
            if(!fixedThreadPool.isTerminated()){
                new MessagePublisher(subManager.getRedisTemplate()).broadcast(pushRules.keys(),MessagePublisher.SEND_EMAIL);
                break;
            }
            else{
                Thread.sleep(1000);
            }
        }

    }


}
