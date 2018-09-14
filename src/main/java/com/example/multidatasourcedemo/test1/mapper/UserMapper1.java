package com.example.multidatasourcedemo.test1.mapper;/*
 *
 * @author 12539 1253950375@qq.com
 *  Created in 2018/9/15
 */

import com.example.multidatasourcedemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper1 {

    @Insert("INSERT INTO user(name,age) values(#{name},#{age})")
    int insert(User user);

    @Select("select * from user")
    List<User> selectAllUser();


    @Update("update user set name=#{name} ,age=#{age} where id=#{id}")
    void updateUser(User u);


    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);
}
