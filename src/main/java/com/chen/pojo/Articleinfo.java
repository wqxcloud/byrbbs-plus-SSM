package com.chen.pojo;

import java.util.Date;

/**
 * Created by ryder on 2017/5/22.
 *
 */
public class Articleinfo {
    private int id;
    private String section_name;
    private String article_title;
    private String article_url;
    private Date article_createtime;
    private Integer article_commentnum;
    private String article_author;

    public Articleinfo(int id, String section_name, String article_title, String article_url, Date article_createtime, Integer article_commentnum, String article_author) {
        this.id = id;
        this.section_name = section_name;
        this.article_title = article_title;
        this.article_url = article_url;
        this.article_createtime = article_createtime;
        this.article_commentnum = article_commentnum;
        this.article_author = article_author;
    }

    public Articleinfo() {
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public Date getArticle_createtime() {
        return article_createtime;
    }

    public void setArticle_createtime(Date article_createtime) {
        this.article_createtime = article_createtime;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Articleinfo{" +
                "id=" + id +
                ", section_name='" + section_name + '\'' +
                ", article_title='" + article_title + '\'' +
                ", article_url='" + article_url + '\'' +
                ", article_createtime=" + article_createtime +
                ", article_commentnum=" + article_commentnum +
                ", article_author='" + article_author + '\'' +
                '}';
    }
}
