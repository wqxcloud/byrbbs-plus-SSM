package com.chen.mapper;

import com.chen.pojo.PushRule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ryder on 2017/6/19.
 *
 */
@Repository
public interface PushRuleMapper {
        List<PushRule> findPushRule();

        PushRule findPushRuleById(Integer id);

        void insertPushRule(PushRule pushRule);

        void updatePushRule(PushRule pushRule);

        void deletePushRule(Integer id);

}
