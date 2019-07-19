package com.undermoonoldman.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/***事务管理相关工具类,开启,提交,回滚,与释放连接*/
@Component()
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.undermoonoldman.service.AccountServiceImpl.*())")
    private void pointCut(){}

    @Before("pointCut()")
    public void beginTransaction(){
        try {
            System.out.println("前置!");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterReturning("pointCut()")
    public void commitTransaciton(){
        try {
            System.out.println("后置!");
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterThrowing("pointCut()")
    public void rollbackTransaciton(){
        try {
            System.out.println("异常!");
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After("pointCut()")
    public void release(){
        try {
            System.out.println("最终!");
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
