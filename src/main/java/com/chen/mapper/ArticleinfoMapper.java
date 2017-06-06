package com.chen.mapper;

import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ryder on 2017/5/22.
 *
 */
@Repository
public interface ArticleinfoMapper {
    //todo:排序显示的各种策略
    //todo:爬取用户评论，检索相似爱好用户
    //todo:加入查询时间的显示，AOP；最新更新时间

//    /**
//     * 通过内部id获取，测试使用
//     * @param id
//     * @return
//     * @throws Exception
//     */
//    Articleinfo findArticleinfoById(int id);

    /**
     * 多条件查询：发帖人模糊匹配，时间四个等级，类别多项或，标题名多项与
     * @param articleinfoQueryVo
     * @return
     * @throws Exception
     */
    List<Articleinfo> findArticleinfosByArticleinfoQueryVo( ArticleinfoQueryVo articleinfoQueryVo);


//    List<Articleinfo> getAll();
//    List<Articleinfo> findArticleinfosByAuthor(String author);
//    List<Articleinfo> findArticleinfosByAuthor(@Param("author") String author);


}
