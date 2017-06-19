package com.chen.pojo;

import java.util.Date;

/**
 * Created by ryder on 2017/5/22.
 *
 */
public class Articleinfo {
    private int id;
    private String section_url;
    private String article_title;
    private String article_url;
    private Date article_createtime;
    private Integer article_comment;
    private String article_author;

    public Articleinfo(int id, String section_url, String article_title, String article_url, Date article_createtime, Integer article_comment, String article_author) {
        this.id = id;
        this.section_url = section_url;
        this.article_title = article_title;
        this.article_url = article_url;
        this.article_createtime = article_createtime;
        this.article_comment = article_comment;
        this.article_author = article_author;
    }

    public Articleinfo() {
    }

    public String getSection_url() {
        return section_url;
    }

    public void setSection_url(String section_url) {
        this.section_url = section_url;
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

    public Integer getArticle_comment() {
        return article_comment;
    }

    public void setArticle_comment(Integer article_comment) {
        this.article_comment = article_comment;
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
                ", section_url='" + section_url + '\'' +
                ", article_title='" + article_title + '\'' +
                ", article_url='" + article_url + '\'' +
                ", article_createtime=" + article_createtime +
                ", article_comment=" + article_comment +
                ", article_author='" + article_author + '\'' +
                '}';
    }
}
