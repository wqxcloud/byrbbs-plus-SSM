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
 */
public class ArticleinfoUpdateManager {
    private SubManager subManager;
    private MessagePublisher messagePublisher;
    private Consumer[] consumers;
    private Producer producer;
    private int THREAD_SIZE;
    private ExecutorService fixedThreadPool;

    private ConcurrentLinkedQueue<Articleinfo> queue = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<String, PushRule> pushRules = null;

    public SubManager getSubManager() {
        return subManager;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public ConcurrentLinkedQueue<Articleinfo> getQueue() {
        return queue;
    }

    public void setQueue(ConcurrentLinkedQueue<Articleinfo> queue) {
        this.queue = queue;
    }

    public void setSubManager(SubManager subManager) {
        this.subManager = subManager;
    }

    public MessagePublisher getMessagePublisher() {
        return messagePublisher;
    }

    public void setMessagePublisher(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    public Consumer[] getConsumers() {
        return consumers;
    }

    public void setConsumers(Consumer[] consumers) {
        this.consumers = consumers;
    }

    public int getTHREAD_SIZE() {
        return THREAD_SIZE;
    }

    public void setTHREAD_SIZE(int THREAD_SIZE) {
        this.THREAD_SIZE = THREAD_SIZE;
    }

    private void init() {
        pushRules = subManager.getPushrules();
        fixedThreadPool = Executors.newFixedThreadPool(THREAD_SIZE);

    }

    //定时执行此方法
    public void update() {
        producer.run();
        //todo：还没改回去
        for (int i = 0; i < 1; i++) {
            consumers[i].setQueue(queue);
            consumers[i].setPushRules(pushRules);
            fixedThreadPool.execute(consumers[i]);
        }
        //调用shutdown()时，ExecutorService 并不会马上关闭，而是不再接收新的任务
        //所以，在调用 shutdown() 方法之前提交到 ExecutorService 的任务都会执行

        while (true) {
            if (queue.isEmpty() && fixedThreadPool.isTerminated()) {
                messagePublisher.broadcast(pushRules.keys(), MessagePublisher.SEND_EMAIL);
                break;
            }
            if (queue.isEmpty())
                fixedThreadPool.shutdown();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

}
