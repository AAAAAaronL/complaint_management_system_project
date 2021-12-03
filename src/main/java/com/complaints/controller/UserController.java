package com.complaints.controller;


import com.complaints.mapper.UserMapper;
import com.complaints.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        return userList;
    }



    @GetMapping("updateUser")
    public String updateUser(){
       /* userMapper.updateUser(new User(109,"Lina",""));*/
        return "ok";
    }
    @GetMapping("deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(120);
        return "ok";
    }

}
