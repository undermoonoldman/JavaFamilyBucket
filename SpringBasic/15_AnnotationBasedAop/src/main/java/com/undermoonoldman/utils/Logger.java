package com.undermoonoldman.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**用于向控制台打印日志,让其在切入点方法执行前执行
 * @Aspect注解标识当前类是一个切面类
 *
 * 天坑注意:基于注解的通知执行顺序与基于XML的通知顺序有不同
 * 前置->最终->后置
 *
 * 但是环绕通知没有顺序的问题,推荐使用环绕通知*/

@Component
@Aspect
public class Logger {
//    @Before("joinPoint()")
//    public void beforePrintLog(){
//        System.out.println("Logger中的beforePrintLog方法开始记录日志了");
//    }
//
//    @AfterReturning("joinPoint()")
//    public void afterReturningPrintLog(){
//        System.out.println("Logger中的afterReturningPrintLog方法开始记录日志了");
//    }
//
//    @AfterThrowing("joinPoint()")
//    public void afterThrowingPrintLog(){
//        System.out.println("Logger中的afterThrowingPrintLog方法开始记录日志了");
//    }
//
//    @After("joinPoint()")
//    public void afterPrintLog(){
//        System.out.println("Logger中的afterPrintLog方法开始记录日志了");
//    }

    /**环绕通知:置配置环绕通知,切入点方法不会执行,只执行通知方法
     * 原因:动态代理中有明确的切入点方法调用
     *
     * 解决:Spring为我们提供了一个接口,ProceedingJoinPoint,该接口有一个方法proceed(),此方法就相当于调用切入点方法
     *     该接口作为环绕通知的方法参数,程序执行时,Spring会为我们提供该接口的实现类来使用*/
    @Around("execution(* com.undermoonoldman.service.impl.*.*(..))")
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint){
        Object returnValue = null;
        try {
            System.out.println("前置通知!");
            Object[] args = joinPoint.getArgs();
            //调用业务方法
            returnValue = joinPoint.proceed(args);
            System.out.println("后置通知!");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("异常通知!");
            throw new RuntimeException();
        } finally {
            System.out.println("最终通知!");
        }
    }

    @Pointcut("execution(* com.undermoonoldman.service.impl.*.*(..))")
    private void joinPoint(){}
}
