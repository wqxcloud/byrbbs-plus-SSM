package com.chen.pubsub.updater;

import com.chen.pojo.Articleinfo;
import com.chen.pojo.PushRule;
import com.chen.pubsub.publisher.MessagePublisher;

import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by ryder on 2017/7/2.
 * 
 */
public class Consumer implements Runnable {
    private ConcurrentLinkedQueue<Articleinfo> queue = null;
    private ConcurrentHashMap<String,PushRule> pushRules = null;
    private MessagePublisher messagePublisher = null;

    public Consumer(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    public ConcurrentLinkedQueue<Articleinfo> getQueue() {
        return queue;
    }

    public void setQueue(ConcurrentLinkedQueue<Articleinfo> queue) {
        this.queue = queue;
    }

    public ConcurrentHashMap<String, PushRule> getPushRules() {
        return pushRules;
    }

    public void setPushRules(ConcurrentHashMap<String, PushRule> pushRules) {
        this.pushRules = pushRules;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            Articleinfo articleinfo = queue.poll();
            //判空+取值，并非原子的，中间可能因为其他线程而取到null，需要二次判断，或者用synchronized同步
            if(articleinfo!=null){
                for(PushRule pushRule:pushRules.values()){
                    if(match(articleinfo,pushRule)){
                        messagePublisher.publishMessage(Integer.toString(pushRule.getId()),articleinfo);
                    }
                }
            }
        }
    }
    public boolean match(Articleinfo articleinfo,PushRule pushRule){
        if(pushRule.getSection_urls().contains(articleinfo.getSection_url())){
            //检查需要包含的关键词
            if(pushRule.getArticle_title_include()!=null && !pushRule.getArticle_title_include().trim().equals("")) {
                String[] includes = pushRule.getArticle_title_include().trim().split(" ");
                for (int i = 0; i < includes.length; i++) {
                    if (!articleinfo.getArticle_title().contains(includes[i]))
                        return false;
                }
            }
            //检查被排除的关键词
            if(pushRule.getArticle_title_exclude()!=null && !pushRule.getArticle_title_exclude().trim().equals("")) {
                String[] excludes = pushRule.getArticle_title_exclude().trim().split(" ");
                for (int i = 0; i < excludes.length; i++) {
                    if (articleinfo.getArticle_title().contains(excludes[i]))
                        return false;
                }
            }
            return true;

        }
        return false;
    }
}
