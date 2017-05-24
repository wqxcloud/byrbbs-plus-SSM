package com.chen.service.impl;

import com.chen.mapper.ArticleinfoMapper;
import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import com.chen.service.ArticleinfoService;
import com.chen.util.BeanUtil;
import com.chen.util.PagedResult;
import com.github.pagehelper.PageHelper;
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

    public PagedResult<Articleinfo> queryByPage(String author, Integer pageNo, Integer pageSize){
        pageNo = pageNo==null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);//startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(articleinfoMapper.findArticleinfosByAuthor(author));
    }

}
