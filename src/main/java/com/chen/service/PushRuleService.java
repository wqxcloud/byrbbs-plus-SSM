package com.chen.service;

import com.chen.pojo.PushRule;

import java.util.List;
import java.util.Set;

/**
 * Created by ryder on 2017/6/19.
 */
public interface PushRuleService {
    List<PushRule> findPushRule();

    PushRule findPushRuleById(Integer id);

    void insertPushRule(PushRule pushRule);

    void updatePushRule(PushRule pushRule);

    void deletePushRule(Integer id);
}
