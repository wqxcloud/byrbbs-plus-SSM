package com.chen.pubsub.updater;

import com.chen.pojo.Articleinfo;
import com.chen.service.ArticleinfoDailyUpdateService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

/**
 * Created by ryder on 2017/7/2.
 */
public class Producer implements Runnable{
    @Resource
    private ArticleinfoDailyUpdateService articleinfoDailyUpdateService;
    private ConcurrentLinkedQueue<Articleinfo> queue = null;
    public Producer(ConcurrentLinkedQueue<Articleinfo> queue){
        this.queue = queue;
    }
    @Override
    public void run() {

        System.out.println("读取所有数据，放入队列");
        Articleinfo articleinfo = new Articleinfo(1,"/board/JobInfo","java1-社招","http://www.baidu.com",new Date(),101,"author1");
        Articleinfo articleinfo2 = new Articleinfo(2,"/board/JobInfo","java2","http://www.google.com",new Date(),102,"author2");
        Articleinfo articleinfo3 = new Articleinfo(3,"/board/JobInfo","java3","titleur3",new Date(),103,"author3");
//        queue.offer(articleinfo);
        queue.offer(articleinfo2);
//        queue.offer(articleinfo3);
    }
}
