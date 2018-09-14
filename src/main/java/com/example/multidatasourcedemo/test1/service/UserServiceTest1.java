package com.example.multidatasourcedemo.test1.service;/*
 *
 * @author 12539 1253950375@qq.com
 *  Created in 2018/9/15
 */

import com.example.multidatasourcedemo.entity.User;
import com.example.multidatasourcedemo.test1.mapper.UserMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceTest1 {

    @Autowired
    private UserMapper1 userMapper1;

    public int insertUser(User user) {
        return userMapper1.insert(user);
    }
}
