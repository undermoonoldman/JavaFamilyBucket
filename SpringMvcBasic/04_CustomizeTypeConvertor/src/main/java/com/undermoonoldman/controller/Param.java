package com.undermoonoldman.controller;

import com.undermoonoldman.bean.Account;
import com.undermoonoldman.bean.Car;
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

    @RequestMapping("/bindbean")
    public String testBindBean(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/bindcollection")
    public String testBindColletion(Car car){
        System.out.println(car);
        return "success";
    }
}
