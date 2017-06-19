package com.chen.pojo;

import java.util.List;

/**
 * Created by ryder on 2017/5/22.
 *
 */
public class ArticleinfoQueryVo {
    private List<String> section_urls;     //类别名，或的关系，准确匹配
    private Integer article_createtime_type;   //1，三天内   2，一周内   3，一个月内  4，一年内
    private Integer article_comment;     //not use
    private String article_author;         //单一模糊匹配
    private List<String> article_titles;    //标题名，与的关系，模糊匹配
    private String article_titles_originalstring;   //article_titles未截断的形式，用于前端显示

    public ArticleinfoQueryVo() {
        this.section_urls = null;
        this.article_createtime_type = null;
        this.article_comment = null;
        this.article_author = null;
        this.article_titles = null;
        this.article_titles_originalstring = null;
    }

    public ArticleinfoQueryVo(List<String> section_urls, Integer article_createtime_type, Integer article_comment, String article_author, List<String> article_titles,String article_titles_originalstring) {
        this.section_urls = section_urls;
        this.article_createtime_type = article_createtime_type;
        this.article_comment = article_comment;
        this.article_author = article_author;
        this.article_titles = article_titles;
        this.article_titles_originalstring = article_titles_originalstring;
    }

    public List<String> getsection_urls() {
        return section_urls;
    }

    public void setsection_urls(List<String> section_urls) {
        this.section_urls = section_urls;
    }

    public Integer getArticle_createtime_type() {
        return article_createtime_type;
    }

    public void setArticle_createtime_type(Integer article_createtime_type) {
        this.article_createtime_type = article_createtime_type;
    }

    public Integer getarticle_comment() {
        return article_comment;
    }

    public void setarticle_comment(Integer article_comment) {
        this.article_comment = article_comment;
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

    public String getArticle_titles_originalstring() {
        return article_titles_originalstring;
    }

    public void setArticle_titles_originalstring(String article_titles_originalstring) {
        this.article_titles_originalstring = article_titles_originalstring;
    }
}
