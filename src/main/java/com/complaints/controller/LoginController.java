package com.complaints.controller;

import com.complaints.mapper.ComplaintsMapper;
import com.complaints.mapper.UserMapper;
import com.complaints.pojo.Complaints;
import com.complaints.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ComplaintsMapper complaintsMapper;
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){
       User user = userMapper.checkAdmin(username,password);
       if (user!=null&&user.getAdmin()==1){//judge the user is administrator or not
           return "redirect:/main.html";//admin page
       }else if (user!=null&&user.getAdmin()==0){
           Collection<Complaints> complaints2 = complaintsMapper.queryComplaintsList();
           model.addAttribute("complaints",complaints2);
           return "comp/monitor";//not administrator turn to the normal page
       }else {
           model.addAttribute("message", "wrong username or password");//wrong password or username tips
           return "login";
       }
    }
    @RequestMapping("/signup")
    public String addUser(@RequestParam("id") Integer id,//sign up method
                          @RequestParam("username") String username,
                          @RequestParam("password") String password){
        userMapper.addUser(new User(id,username,password,0));//add user information into database

        return "login";
    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }


}
