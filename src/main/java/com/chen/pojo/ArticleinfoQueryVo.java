package com.chen.pojo;

import java.util.List;

/**
 * Created by ryder on 2017/5/22.
 *
 */
public class ArticleinfoQueryVo {
    private List<String> section_names;     //类别名，或的关系，准确匹配
    private Integer article_createtime_type;   //1，三天内   2，一周内   3，一个月内  4，一年内
    private Integer article_commentnum;     //not use
    private String article_author;         //单一模糊匹配
    private List<String> article_titles;    //标题名，与的关系，模糊匹配

    public ArticleinfoQueryVo() {
        this.section_names = null;
        this.article_createtime_type = null;
        this.article_commentnum = null;
        this.article_author = null;
        this.article_titles = null;
    }

    public ArticleinfoQueryVo(List<String> section_names, Integer article_createtime_type, Integer article_commentnum, String article_author, List<String> article_titles) {
        this.section_names = section_names;
        this.article_createtime_type = article_createtime_type;
        this.article_commentnum = article_commentnum;
        this.article_author = article_author;
        this.article_titles = article_titles;
    }

    public List<String> getSection_names() {
        return section_names;
    }

    public void setSection_names(List<String> section_names) {
        this.section_names = section_names;
    }

    public Integer getArticle_createtime_type() {
        return article_createtime_type;
    }

    public void setArticle_createtime_type(Integer article_createtime_type) {
        this.article_createtime_type = article_createtime_type;
    }

    public Integer getArticle_commentnum() {
        return article_commentnum;
    }

    public void setArticle_commentnum(Integer article_commentnum) {
        this.article_commentnum = article_commentnum;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public List<String> getArticle_titles() {
        return article_titles;
    }

    public void setArticle_titles(List<String> article_titles) {
        this.article_titles = article_titles;
    }
}
