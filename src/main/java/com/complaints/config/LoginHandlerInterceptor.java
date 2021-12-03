/*package com.complaints.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后应该有用户的session

        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            //没有登录
            request.setAttribute("message","cannot access, please login");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }


}*/
