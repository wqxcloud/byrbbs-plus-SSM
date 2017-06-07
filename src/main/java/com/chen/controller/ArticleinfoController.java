package com.chen.controller;

import com.chen.pojo.ArticleinfoQueryVo;
import com.chen.service.ArticleinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by ryder on 2017/5/23.
 *
 */
@Controller
@SessionAttributes("articleinfoQueryVo")
public class ArticleinfoController {
    @Resource
    private ArticleinfoService articleinfoService;

    @RequestMapping("/firstPage")
    public String list(Map<String, Object> map) {
        ArticleinfoQueryVo articleinfoQueryVo = new ArticleinfoQueryVo();
        map.put("articleinfoQueryVo",articleinfoQueryVo);
        map.put("pageInfo", articleinfoService.queryByPage(articleinfoQueryVo, 1, 10));
        return "list";
    }
    @RequestMapping(value = "/page/{pageNo}")
    public String findByNum(@PathVariable("pageNo") Integer pageNo, HttpSession session, Map<String, Object> map) {
        map.put("pageInfo", articleinfoService.queryByPage((ArticleinfoQueryVo) session.getAttribute("articleinfoQueryVo"), pageNo, 10));
        return "list";
    }
    @RequestMapping("/pageSize/{pageSize}")
    public String pageSize(@PathVariable("pageSize") Integer pageSise, HttpSession session, Map<String, Object> map){
        map.put("pageInfo", articleinfoService.queryByPage((ArticleinfoQueryVo) session.getAttribute("articleinfoQueryVo"), 1, pageSise));
        return "list";
    }

    @RequestMapping(value = "/find")
    public String find(@RequestParam("author") String author,@RequestParam("keyWords")String keyWords, HttpSession session,Map<String, Object> map) {
        ArticleinfoQueryVo articleinfoQueryVo = (ArticleinfoQueryVo)session.getAttribute("articleinfoQueryVo");
        articleinfoQueryVo.setArticle_author(author);
        String[] strs = keyWords.split(" ");
        List<String> words = Arrays.asList(strs);
        articleinfoQueryVo.setArticle_titles(words);
        articleinfoQueryVo.setArticle_titles_originalstring(keyWords);
        map.put("pageInfo", articleinfoService.queryByPage(articleinfoQueryVo, 1, 10));
        return "list";
    }

}
