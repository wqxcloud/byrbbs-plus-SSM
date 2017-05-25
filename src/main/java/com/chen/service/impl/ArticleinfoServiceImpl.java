package com.chen.service.impl;

import com.chen.mapper.ArticleinfoMapper;
import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import com.chen.service.ArticleinfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ryder on 2017/5/23.
 *
 */

@Service("articleinfoService")
public class ArticleinfoServiceImpl implements ArticleinfoService{
    @Resource
    private ArticleinfoMapper articleinfoMapper;

    public List<Articleinfo> getAll(){
        return this.articleinfoMapper.getAll();
    }

    public List<Articleinfo> findArticleinfosByArticleinfoQueryVo(ArticleinfoQueryVo articleinfoQueryVo){
        return this.articleinfoMapper.findArticleinfosByArticleinfoQueryVo(articleinfoQueryVo);
    }

    public PageInfo<Articleinfo> queryByPage(ArticleinfoQueryVo articleinfoQueryVo, Integer pageNo, Integer pageSize){
        pageNo = (pageNo==null||pageNo<1)?1:pageNo;
        pageSize = (pageSize == null||pageNo<1)?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);//startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        List<Articleinfo> list = articleinfoMapper.findArticleinfosByArticleinfoQueryVo(articleinfoQueryVo);
        return new PageInfo<Articleinfo>(list);
    }

}
