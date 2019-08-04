package com.undermoonoldman.controller;

import com.undermoonoldman.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/***
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
//把 msg 存到 session 中，用于方法之间参数的共享
@SessionAttributes(value = {"msg"})
public class AnnoController {
    @RequestMapping("/testRequestParam")
    /**
     * @RequestParam 注解解决前端传参与后端接受参数命名不一致的问题，使用 name 或 value 属性来指定接受前端参数的名称然后绑定给后端参数
     */
    public String testRequestParam(@RequestParam(name = "name", required = true) String username){
        System.out.println("执行了 testRequestParam");
        System.out.println("username = " + username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    /**
     * @RequestBody 获取到请求体的内容，get 方法没有请求体
     */
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了 testRequestBody");
        System.out.println(body);
        return "success";
    }


    @RequestMapping("/testPathVariable/{sid}")
    /**
     * @PathVariable 配合 RestFul 风格的 URL 实现一条路径多种功能
     */
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了 testPathVariable");
        System.out.println(id);
        return "success";
    }


    @RequestMapping("/testRequestHeader")
    /**
     * @RequestHeader 指定请求头内容
     */
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了 testRequestHeader");
        System.out.println(header);
        return "success";
    }


    @RequestMapping("/testCookieValue")
    /**
     * @CookieValue 指定请求头内容
     */
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了 testCookieValue");
        System.out.println(cookieValue);
        return "success";
    }


    @RequestMapping("/testModelAttribute_01")
    public String testModelAttribute_01(User user){
        System.out.println("执行了 testModelAttribute");
        System.out.println(user);
        return "success";
    }


    /***
     * 加在参数上的 @ModelAttribute 注解与无返回值使用 Map 的方式配合
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute_02")
    public String testModelAttribute_02(@ModelAttribute("abc") User user){
        System.out.println("执行了 testModelAttribute");
        System.out.println(user);
        return "success";
    }


    /***
     * 注意，@SessionAttributes 注解只能加在类上面
     * 向 Session 中存入数据
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("执行了 testSessionAttributes");
        model.addAttribute("msg", "testSessionAttributes success!");
        return "success";
    }

    /***
     * 从 Model 中取得数据时要使用 Model 的实现类
     * @param model
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap model){
        System.out.println("执行了 getSessionAttributes");
        String msg = (String) model.get("msg");
        System.out.println("msg : " + msg);
        return "success";
    }

    /***
     * 清除 Session 中的数据
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("执行了 delSessionAttributes");
        status.setComplete();
        return "success";
    }

    /**
     * @ModleAttribute 注解加在方法上可以在其他方法执行前执行该方法
     * 应用场景，可以在前台提交数据缺失时用后台数据库默认数据进行补全
     * 例如：前台传数据时缺失了 Data 数据，后台通过用户名查出一个默认数据填充到 Date 中
     */
    @ModelAttribute
    public User beforeTestModelAttribute_01(String name){
        System.out.println("执行了 beforeTestModelAttribute_01");
        System.out.println("查询数据库");
        User user = new User();
        user.setAge(20);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }


    @ModelAttribute
    public void beforeTestModelAttribute_02(String name, Map<String, User> map){
        System.out.println("执行了 beforeTestModelAttribute_02");
        System.out.println("查询数据库");
        User user = new User();
        user.setAge(20);
        user.setName(name);
        user.setDate(new Date());
        map.put("abc", user);
    }
}
