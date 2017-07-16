package com.chen.timedjob;

import com.chen.pubsub.updater.ArticleinfoUpdateManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ryder on 2017/7/16.
 */
@Component
public class PubSubJob {
    @Resource
    ArticleinfoUpdateManager articleinfoUpdateManager;

    //    @Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 0 23 * * ?")
    public void dailyTask() {
        articleinfoUpdateManager.update();
    }
}
