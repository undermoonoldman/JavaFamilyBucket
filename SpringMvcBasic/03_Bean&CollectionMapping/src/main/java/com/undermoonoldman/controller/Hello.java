package com.undermoonoldman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello world!");
        return "success";
    }

    /**value与path都可以用来指定请求路径
     * params可以用来指定请求携带的参数,还可以绑定请求参数的值
     * header指定请求必须携带的请求头*/
    @RequestMapping(path = "/fuck")
    public String fuckYou(){
        System.out.println("fuck you!");
        return "success";
    }
}
