package com.undermoonoldman.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor_03 implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了 MyInterceptor_03 postHandle方法并进行转发");
        request.getRequestDispatcher("/WEB-INF/pages/pullover.jsp").forward(request, response);
    }
}
