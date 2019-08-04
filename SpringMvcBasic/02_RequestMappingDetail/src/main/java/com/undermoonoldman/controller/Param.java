package com.undermoonoldman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class Param {
    @RequestMapping(path = "/test")
    public String testParam(String username){
        System.out.println("testParam!");
        System.out.println(username);
        return "success";
    }
}
