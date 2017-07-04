package com.chen.service.impl;

import com.chen.mapper.ArticleinfoDailyUpdateMapper;
import com.chen.pojo.Articleinfo;
import com.chen.service.ArticleinfoDailyUpdateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ryder on 2017/7/3.
 *
 */
@Service("articleinfoDailyUpdateService")
public class ArticleinfoDailyUpdateServiceImpl implements ArticleinfoDailyUpdateService{
    @Resource
    private ArticleinfoDailyUpdateMapper articleinfoDailyUpdateMapper;
    @Override
    public List<Articleinfo> getTodayAll() {
        return articleinfoDailyUpdateMapper.getTodayAll();
    }
}
