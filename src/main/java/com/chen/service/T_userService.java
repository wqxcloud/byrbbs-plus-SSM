package com.chen.service;

import com.chen.pojo.T_user;

import java.util.Set;

/**
 * Created by ryder on 2017/6/14.
 * 后台登录Service
 */
public interface T_userService {
    /**
     * Shiro的登录验证，通过用户名查询用户信息
     */
    public T_user findUserByUsername(String username) ;

    /**
     * 根据账号查找角色名称
     */
    public Set<String> findRoles(String username) ;

    /**
     * 根据账号查找权限
     */
    public Set<String> findPermissions(String username) ;

    /**
     * 新用户注册
     */
    public void insertUser(T_user t_user) ;

    /**
     * 修改密码
     */
    public void updateUser(T_user t_user) ;
}
