package com.chen.mapper;

import com.chen.pojo.SectionName;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ryder on 2017/6/20.
 *
 */
@Repository
public interface SectionNameMapper {
    public List<SectionName> findAll();
}
