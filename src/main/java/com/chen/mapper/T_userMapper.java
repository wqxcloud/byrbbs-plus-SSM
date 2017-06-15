package com.chen.mapper;

import com.chen.pojo.T_user;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by ryder on 2017/6/14.
 *
 */
@Repository
public interface T_userMapper {
        T_user findUserByUsername(String username);

        Set<String> findRoles(String username);

        Set<String> findPermissions(String username);

        void insertUser(T_user user);

        void updateUser(T_user user);
}
