package com.chen.service.impl;

import com.chen.mapper.SectionNameMapper;
import com.chen.pojo.SectionName;
import com.chen.service.SectionNameService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ryder on 2017/6/20.
 *
 */
@Service("sectionNameService")
public class SectionNameServiceImpl implements SectionNameService {
    @Resource
    private SectionNameMapper sectionNameMapper;
    private final Map<String,SectionName> map = new HashMap<>();
    private volatile static boolean flag = false;
    @PostConstruct
    public void initMap(){
        List<SectionName> list = sectionNameMapper.findAll();
        for (SectionName sectionName : list) {
            map.put(sectionName.getSection_url(), sectionName);
        }
    }
    public Map<String, SectionName> UrlToNameMap() {
        return map;
    }
}
