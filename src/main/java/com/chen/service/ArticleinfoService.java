package com.chen.service;

import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import com.chen.util.PagedResult;

import java.util.List;

/**
 * Created by ryder on 2017/5/23.
 */
public interface ArticleinfoService {
    List<Articleinfo> getAll();
    List<Articleinfo> findArticleinfosByArticleinfoQueryVo(ArticleinfoQueryVo articleinfoQueryVo);

    PagedResult<Articleinfo> queryByPage(String author,Integer pageNo,Integer pageSize);
}
