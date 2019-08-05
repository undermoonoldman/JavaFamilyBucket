package com.undermoonoldman.controller;

import com.undermoonoldman.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回值类型为 String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("执行了 testString");
        //模拟数据库查询数据
        User user = new User();
        user.setName("HanMeiMei");
        user.setAge(18);

        model.addAttribute("user", user);
        return "success";
    }

    /***
     * 使用 Servlet 原生 api 进行转发
     * 返回值类型为 void
     * 没有返回值默认会去查找同路径下的视图
     * 转发在一次请求中完成，不用写项目名(转发需要自己填写视图所在的目录)
     * @param request
     * @param response
     */
    @RequestMapping("/testVoidForward")
    public void testVoidForward(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了 testVoidForward");

        try {
            //转发要手动填写视图所在目录，视图解析器不会工作
            request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
            //转发完成后，后续流程还会执行，如需提前终止，需要 return
            return;
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * 使用 Servlet 原生 api 进行重定向
     * 没有返回返回值类型为 void
     * 值默认会去查找同路径下的视图
     * 重定向在两次请求中完成，需要些项目名(需要自己填写视图所在的目录)
     * @param request
     * @param response
     */
    @RequestMapping("/testVoidRedirect")
    public void testVoidRedirect(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了 testVoidRedirect");


        try {
            //重定向因为是一个新的请求所以无法进入 WEB-INF 目录下
            response.sendRedirect(request.getContextPath() + "/redirect.jsp");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }


    /***
     * 服务器不进行跳转，直接通过输出流把页面写回浏览器
     * 需要处理中文乱码问题
     * @param request
     * @param response
     */
    @RequestMapping("/testVoidWrite")
    public void testVoidWrite(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了 testVoidWrite");

        /***
         * 直接写回的方式需要解决相应中文乱码问题
         */
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        try {
            response.getWriter().print("直接写回相应");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }


    /***
     * 返回 ModelAndView 对象
     * @param modelAndView
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(ModelAndView modelAndView){
        System.out.println("执行了 testModelAndView");
        ModelAndView mv = new ModelAndView();
        //模拟数据库查询数据
        User user = new User();
        user.setName("HanMeiMei");
        user.setAge(18);

        //mv 中添加的对象，也会存入到 request 中
        mv.addObject("user", user);

        //设置要跳转的页面，视图解析器正常工作
        mv.setViewName("success");

        return mv;
    }


    /***
     * 使用关键字进行转发
     * 同样无法使用视图解析器
     */
    @RequestMapping("testForward")
    public String testForward(){
        System.out.println("执行了 testForward");
        return "forward:/WEB-INF/pages/success.jsp";
    }


    /***
     * 使用关键字进行重定向
     * 不写项目名称也可以重定向，这一点与 Servlet 原生 Api 不同
     */
    @RequestMapping("testRedirect")
    public String testRedirect(){
        System.out.println("执行了 testRedirect");
        return "redirect:/redirect.jsp";
    }

    /***
     * @ResponseBody 用于返回 json 把对象序列化为字符串格式
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("testResponseBody")
    public User testResponseBody(@RequestBody User user){
        System.out.println("执行了 testResponseBody");
        //后端把 json 字符串封装到 user 对象中了
        user.setName("HanMeiMei");
        user.setAge(38);
        System.out.println(user);
        return user;
    }
}
