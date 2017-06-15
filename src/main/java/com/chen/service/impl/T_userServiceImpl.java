package com.chen.service.impl;

import com.chen.mapper.T_userMapper;
import com.chen.pojo.T_user;
import com.chen.service.T_userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by ryder on 2017/6/14.
 *
 */
@Service("t_userService")
public class T_userServiceImpl implements T_userService {
    @Resource
    private T_userMapper t_userMapper;

    public T_user findUserByUsername(String username) {
        return t_userMapper.findUserByUsername(username);
    }

    public Set<String> findRoles(String username) {
        return t_userMapper.findRoles(username);
    }

    public Set<String> findPermissions(String username) {
        return t_userMapper.findPermissions(username);
    }

    public void insertUser(T_user t_user) {
        t_userMapper.insertUser(t_user);
    }

    public void updateUser(T_user t_user) {
        t_userMapper.updateUser(t_user);
    }
}

