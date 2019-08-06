package com.undermoonoldman.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SysExceptionResovler implements HandlerExceptionResolver {
    /***
     * 自定义异常处理器，用于处理异常逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //获取异常对象
        SysException e = null;
        if(ex instanceof SysException){
            e = (SysException)ex;
        } else{
            e = new SysException("系统正在维护");
        }
        ModelAndView mv = new ModelAndView();
        //携带信息进行跳转
        mv.addObject("errorMsg", e.getMsg());
        mv.setViewName("error");
        return mv;
    }
}
