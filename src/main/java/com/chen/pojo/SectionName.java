package com.chen.pojo;

import java.util.Date;

/**
 * Created by ryder on 2017/6/20.
 *
 */
public class SectionName {
    private String section_url;
    private String section_name;
    private String section_article_total;
    private String top_section_num;
    private Date updatetime;

    public SectionName() {
        this.section_url = "";
        this.section_name = "";
        this.section_article_total = "";
        this.top_section_num = "";
        this.updatetime = null;
    }

    public String getSection_url() {
        return section_url;
    }

    public void setSection_url(String section_url) {
        this.section_url = section_url;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSection_article_total() {
        return section_article_total;
    }

    public void setSection_article_total(String section_article_total) {
        this.section_article_total = section_article_total;
    }

    public String getTop_section_num() {
        return top_section_num;
    }

    public void setTop_section_num(String top_section_num) {
        this.top_section_num = top_section_num;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "SectionName{" +
                "section_url='" + section_url + '\'' +
                ", section_name='" + section_name + '\'' +
                ", section_article_total='" + section_article_total + '\'' +
                ", top_section_num='" + top_section_num + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }
}

