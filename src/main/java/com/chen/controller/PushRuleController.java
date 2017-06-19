package com.chen.controller;

import com.chen.pojo.PushRule;
import com.chen.service.PushRuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by ryder on 2017/6/19.
 *
 */
@Controller()
public class PushRuleController {
    @Resource
    private PushRuleService pushRuleService;

    @RequestMapping("/pushrules")
    public String findAll(Map<String, Object> map) {
        map.put("pushrules", pushRuleService.findPushRule());
        return "pushrule";
    }

    @RequestMapping("/pushrule/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        pushRuleService.deletePushRule(id);
        return "redirect:/pushrules";
    }

    //点击修改/新建后(新建按钮的id为-1，修改元素的id均大于0)
    @RequestMapping("/pushrule/update/{id}")
    public String update(@PathVariable("id") Integer id, Map<String, Object> map) {
        PushRule pushRule = null;
        if (id > 0) {
            pushRule = pushRuleService.findPushRuleById(id);
        } else
            pushRule = new PushRule();
        map.put("pushRule", pushRule);
        return "update_pushrule";
    }

    //修改完成/创建完成后的保存
    @RequestMapping("/pushrule/save")
    public String save(@RequestParam("id") Integer id,
                       @RequestParam("rule_name") String rule_name,
                       @RequestParam("section_urls") String section_urls,
                       @RequestParam("article_title_include") String article_title_include,
                       @RequestParam("article_title_exclude") String article_title_exclude,
                       @RequestParam("pushtime_type") Integer pushtime_type,
                       Map<String,Object> map) {
        PushRule pushRule = new PushRule();
        pushRule.setId(id);
        pushRule.setRule_name(rule_name);
        pushRule.setSection_urls(section_urls);
        pushRule.setArticle_title_include(article_title_include);
        pushRule.setArticle_title_exclude(article_title_exclude);
        pushRule.setPushtime_type(pushtime_type);
        if (id > 0) {
            pushRuleService.updatePushRule(pushRule);
            map.put("pushRule",pushRule);
            return "update_pushrule";
        }
        else {
            pushRuleService.insertPushRule(pushRule);
            map.put("pushrules", pushRuleService.findPushRule());
            return "pushrule";
        }
    }
}
