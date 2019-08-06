package com.undermoonoldman.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor_02 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了 MyInterceptor_02 preHandle方法并进行转发且不放行");
        request.getRequestDispatcher("/WEB-INF/pages/pullover.jsp").forward(request, response);
//        return true;
        return false;
    }
}
