package com.chen.mapper;

import com.chen.pojo.Articleinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ryder on 2017/7/3.
 *
 */
@Repository
public interface ArticleinfoDailyUpdateMapper {
    List<Articleinfo> getTodayAll();
}
