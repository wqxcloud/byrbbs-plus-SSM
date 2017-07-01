package com.chen.mapper;

import com.chen.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by ryder on 2017/6/14.
 *
 */
@Repository
public interface UserMapper {
        User findUserById(Integer id);

        User findUserByUsername(String username);

        Set<String> findRoles(String username);

        Set<String> findPermissions(String username);

        void insertUser(User user);

        void updateUser(User user);
}
