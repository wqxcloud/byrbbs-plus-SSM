package com.chen.service;

import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ryder on 2017/5/23.
 */
public interface ArticleinfoService {
    List<Articleinfo> getAll();
    List<Articleinfo> findArticleinfosByArticleinfoQueryVo(ArticleinfoQueryVo articleinfoQueryVo);

    PageInfo<Articleinfo> queryByPage(@Param("articleinfoQueryVo") ArticleinfoQueryVo articleinfoQueryVo, Integer pageNo, Integer pageSize);
}
