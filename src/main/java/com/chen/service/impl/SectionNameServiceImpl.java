package com.chen.service.impl;

import com.chen.mapper.SectionNameMapper;
import com.chen.pojo.SectionName;
import com.chen.service.SectionNameService;
import org.springframework.stereotype.Service;

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
    private  Map<String,SectionName> map = null;
    private volatile static boolean flag = false;
    public Map<String,SectionName> UrlToNameMap() {
        //使用双检锁完成单例
        if(!flag) {
            synchronized (SectionNameServiceImpl.class) {
                if(!flag) {
                    List<SectionName> list = sectionNameMapper.findAll();
                    map = new HashMap<>();
                    for (SectionName sectionName : list) {
                        map.put(sectionName.getSection_url(), sectionName);
                    }
                    flag = true;
                }
            }
        }
        return map;
    }
}
