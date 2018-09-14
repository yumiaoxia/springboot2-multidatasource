package com.example.multidatasourcedemo.controller;/*
 *
 * @author 12539 1253950375@qq.com
 *  Created in 2018/9/15
 */

import com.example.multidatasourcedemo.controller.command.UserInsertCommand;
import com.example.multidatasourcedemo.entity.User;
import com.example.multidatasourcedemo.test1.service.UserServiceTest1;
import com.example.multidatasourcedemo.test2.service.UserServiceTest2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户中心")
@RestController
public class UserController {

    @Autowired
    private UserServiceTest1 userServiceTest1;

    @Autowired
    private UserServiceTest2 userServiceTest2;

    @ApiOperation("用户插入数据库1")
    @PostMapping("/insertTest1")
    public int insertTest1(UserInsertCommand command) {
        User user = new User();
        user.setName(command.getName());
        user.setAge(command.getAge());
        return userServiceTest1.insertUser(user);
    }

    @ApiOperation("用户插入数据库2")
    @PostMapping("/insertTest2")
    public int insertTest2(UserInsertCommand command) {
        User user = new User();
        user.setName(command.getName());
        user.setAge(command.getAge());
        return userServiceTest2.insertUser(user);
    }

}
