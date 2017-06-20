package com.chen.service.impl;

import com.chen.mapper.UserMapper;
import com.chen.pojo.User;
import com.chen.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by ryder on 2017/6/14.
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    public Set<String> findRoles(String username) {
        return userMapper.findRoles(username);
    }

    public Set<String> findPermissions(String username) {
        return userMapper.findPermissions(username);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}

