package com.ui;


import com.undermoonoldman.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**模拟客户端操作*/
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //根据ID获取bean对象
        AccountService accountService = (AccountService)ac.getBean("accountService");

        accountService.saveAccount();

    }
}
