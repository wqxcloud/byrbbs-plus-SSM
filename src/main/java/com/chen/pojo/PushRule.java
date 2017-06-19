package com.chen.pojo;

/**
 * Created by ryder on 2017/6/19.
 *
 */
public class PushRule {
    private Integer id;
    private String rule_name;
    private String section_urls;
    private String article_title_include;
    private String article_title_exclude;
    private Integer pushtime_type;

    public PushRule() {
        this.id = -1;
        this.rule_name = "";
        this.section_urls = "";
        this.article_title_include = "";
        this.article_title_exclude = "";
        this.pushtime_type = -1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule_name() {
        return rule_name;
    }

    public void setRule_name(String rule_name) {
        this.rule_name = rule_name;
    }

    public String getSection_urls() {
        return section_urls;
    }

    public void setSection_urls(String section_urls) {
        this.section_urls = section_urls;
    }

    public String getArticle_title_include() {
        return article_title_include;
    }

    public void setArticle_title_include(String article_title_include) {
        this.article_title_include = article_title_include;
    }

    public String getArticle_title_exclude() {
        return article_title_exclude;
    }

    public void setArticle_title_exclude(String article_title_exclude) {
        this.article_title_exclude = article_title_exclude;
    }

    public Integer getPushtime_type() {
        return pushtime_type;
    }

    public void setPushtime_type(Integer pushtime_type) {
        this.pushtime_type = pushtime_type;
    }

    @Override
    public String toString() {
        return "PushRule{" +
                "id=" + id +
                ", rule_name='" + rule_name + '\'' +
                ", section_urls='" + section_urls + '\'' +
                ", article_title_include='" + article_title_include + '\'' +
                ", article_title_exclude='" + article_title_exclude + '\'' +
                ", pushtime_type=" + pushtime_type +
                '}';
    }
}
