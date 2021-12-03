package com.complaints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询数据库所有信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
 /*   @GetMapping("/addUSer")
    public String addUser(){
        String sql = "insert into complaintproject.user(id,lastname) values (106,'Aaron')";
        jdbcTemplate.update(sql);
        return "update complete";
    }*/
}
