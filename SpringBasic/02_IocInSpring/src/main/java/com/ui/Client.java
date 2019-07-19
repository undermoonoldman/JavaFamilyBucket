package com.ui;

import com.undermoonoldman.dao.AccountDao;
import com.undermoonoldman.factory.BeanFactory;
import com.undermoonoldman.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**模拟客户端操作*/
public class Client {
    /**获取Spring IOC 的核心容器，并根据ID获取对象
     * ApplicationContext的三个常用实现类，读取配置文件立即创建对象适合单例对象
     *
     * 1.ClassPathXmlApplicationContext，加载类路径下的配置文件
     * 2.FileSystemXmlApplicationContext，加载磁盘任意路径的配置文件，必需有访问权限
     * 3.AnnotationConfigApplicationContext用于读取注解创建容器
     *
     * 如果在xml中配置某个bean采用延迟加载，就是说用ID获取对象时才创建，多例对象适用*/
    public static void main(String[] args) {
        //获取核心容器对象
        //        ApplicationContext ac = new FileSystemXmlApplicationContext("/Users/arthur/Documents/Code/JAVA/SpringBasic/src/main/resources/bean.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //根据ID获取bean对象
        AccountService accountService = (AccountService)ac.getBean("accountService");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

        System.out.println(accountDao);
        System.out.println(accountService);
    }
}
