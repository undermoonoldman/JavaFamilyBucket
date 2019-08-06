package com.undermoonoldman.controller;


import com.undermoonoldman.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("执行了 testException");
        //模拟捕获并抛出自定义异常
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询用户出现错误");
        }
        return "success";
    }

    @RequestMapping("/testInterceptor_01")
    public String testInterceptor_01(){
        System.out.println("执行了 testInterceptor_01");
        return "success";
    }

    @RequestMapping("/testInterceptor_02")
    public String testInterceptor_02(){
        System.out.println("执行了 testInterceptor_02");
        return "success";
    }

    @RequestMapping("/testInterceptor_03")
    public String testInterceptor_03(){
        System.out.println("执行了 testInterceptor_03");
        return "success";
    }

    @RequestMapping("/testInterceptorChain")
    public String testInterceptorChain(){
        System.out.println("执行了 testInterceptorChain");
        return "success";
    }
}
