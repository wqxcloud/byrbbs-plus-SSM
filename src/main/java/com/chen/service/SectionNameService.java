package com.chen.service;


import com.chen.pojo.SectionName;

import java.util.Map;

/**
 * Created by ryder on 2017/6/20.
 *
 */
public interface SectionNameService {
    public Map<String,SectionName> UrlToNameMap();
    public void initMap();

}
