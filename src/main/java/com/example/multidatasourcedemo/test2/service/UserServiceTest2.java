package com.example.multidatasourcedemo.test2.service;/*
 *
 * @author 12539 1253950375@qq.com
 *  Created in 2018/9/15
 */

import com.example.multidatasourcedemo.entity.User;
import com.example.multidatasourcedemo.test2.mapper.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceTest2 {

    @Autowired
    private UserMapper2 userMapper2;

    public int insertUser(User user) {
        return userMapper2.insert(user);
    }
}
