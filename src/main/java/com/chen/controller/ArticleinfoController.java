package com.chen.controller;

import com.chen.pojo.Articleinfo;
import com.chen.service.ArticleinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by ryder on 2017/5/23.
 *
 */
@Controller
public class ArticleinfoController {
    @Resource
    private ArticleinfoService articleinfoService;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("articleinfos",articleinfoService.getAll());
        return "list";
    }

}
