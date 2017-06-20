package com.chen.service.impl;

import com.chen.mapper.PushRuleMapper;
import com.chen.pojo.PushRule;
import com.chen.service.PushRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ryder on 2017/6/19.
 *
 */
@Service("pushRuleService")
public class PushRuleServiceImpl implements PushRuleService{
    @Resource
    private PushRuleMapper pushRuleMapper;

    public List<PushRule> findPushRule() {
        return pushRuleMapper.findPushRule();
    }

    public PushRule findPushRuleById(Integer id) {
        return pushRuleMapper.findPushRuleById(id);
    }

    public void insertPushRule(PushRule pushRule) {
        pushRuleMapper.insertPushRule(pushRule);
    }

    public void updatePushRule(PushRule pushRule) {
        pushRuleMapper.updatePushRule(pushRule);
    }

    public void deletePushRule(Integer id) {
        pushRuleMapper.deletePushRule(id);
    }
}
