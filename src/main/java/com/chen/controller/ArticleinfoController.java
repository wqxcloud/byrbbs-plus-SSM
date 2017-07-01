package com.chen.controller;

import com.chen.mapper.SectionNameMapper;
import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import com.chen.pojo.SectionName;
import com.chen.service.ArticleinfoService;
import com.chen.service.SectionNameService;
import com.chen.service.impl.SectionNameServiceImpl;
import com.github.pagehelper.PageInfo;
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
    @Resource
    private SectionNameService sectionNameService;

    public Map<String,SectionName>  sectionUrlToName;
    @RequestMapping("/firstPage")
    public String list(Map<String, Object> map,HttpSession session) {
        ArticleinfoQueryVo articleinfoQueryVo = null;

        sectionUrlToName = sectionNameService.UrlToNameMap();
        if(session.getAttribute("articleinfoQueryVo")==null){
            articleinfoQueryVo = new ArticleinfoQueryVo();
            map.put("articleinfoQueryVo",articleinfoQueryVo);

        }
        else{
            articleinfoQueryVo = (ArticleinfoQueryVo)session.getAttribute("articleinfoQueryVo");
        }
        int pageSize = 20;
        int pageNo = 1;
        if(session.getAttribute("pageSize")==null)
            session.setAttribute("pageSize",pageSize);
        else
            pageSize = (Integer) session.getAttribute("pageSize");
        PageInfo<Articleinfo> pageInfo = articleinfoService.queryByPage(articleinfoQueryVo, pageNo, pageSize);
        pageInfoSectionUrlToName(pageInfo);
        map.put("pageInfo", pageInfo);
        return "list";
    }
    @RequestMapping(value = "/page/{pageNo}")
    public String findByNum(@PathVariable("pageNo") Integer pageNo, HttpSession session, Map<String, Object> map) {
        int pageSize = (Integer) session.getAttribute("pageSize");
        PageInfo<Articleinfo> pageInfo = articleinfoService.queryByPage((ArticleinfoQueryVo) session.getAttribute("articleinfoQueryVo"), pageNo, pageSize);
        pageInfoSectionUrlToName(pageInfo);
        map.put("pageInfo", pageInfo);
        return "list";
    }
    @RequestMapping("/pageSize/{pageSize}")
    public String pageSize(@PathVariable("pageSize") Integer pageSise, HttpSession session, Map<String, Object> map){
        session.setAttribute("pageSize",pageSise);
        PageInfo<Articleinfo> pageInfo = articleinfoService.queryByPage((ArticleinfoQueryVo) session.getAttribute("articleinfoQueryVo"), 1, pageSise);
        pageInfoSectionUrlToName(pageInfo);
        map.put("pageInfo",pageInfo);
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

        PageInfo<Articleinfo> pageInfo = articleinfoService.queryByPage(articleinfoQueryVo, 1, (Integer)session.getAttribute("pageSize"));
        pageInfoSectionUrlToName(pageInfo);
        map.put("pageInfo", pageInfo);
        return "list";
    }

    private void pageInfoSectionUrlToName(PageInfo<Articleinfo> pageInfo){
        for(int i=0;i<pageInfo.getList().size();i++){
            Articleinfo articleinfo = pageInfo.getList().get(i);
            //此处的setSection_url已经转换为setSection_name
            articleinfo.setSection_url(sectionUrlToName.get(articleinfo.getSection_url()).getSection_name());
            pageInfo.getList().set(i,articleinfo);
        }
    }

}
