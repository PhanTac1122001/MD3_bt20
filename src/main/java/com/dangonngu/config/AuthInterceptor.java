package com.dangonngu.config;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // check xem cos dang nhap admin chua
        // Lay ra tu session
        HttpSession session = request.getSession();
        if(session.getAttribute("admin") != null){
            return true;
        }
        // dieu huong sang trang login
        response.sendRedirect("/logon");
        return false;
    }
}
