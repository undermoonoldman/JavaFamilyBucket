package com.undermoonoldman.service;


import com.undermoonoldman.bean.Account;
import com.undermoonoldman.config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**Spring整合Junit
 * <!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
 *
 *     <artifactId>spring-test</artifactId>
 *     <version>5.0.14.RELEASE</version>
 *     <scope>test</scope>
 * 1.先导包
 * 2.使用junit注解 @Runwith 替换原有main方法,替换为Spring提供的
 * 3.告知Spring运行器,spring与IOC是基于xml还是注解的,并且说明注解的位置
 * @ContextCOnfiguration
 *      locations:指定xml文件的位置,加上classpath关键字,表示在类路径下
 *      classes:指定注解类所在的位置
 *
 *天坑注意:当使用Spring5版本时,要求junit版本至少为4.1.2以上*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void testTransfer(){
        System.out.println(accountService);
        Account aaa = accountService.findAccountById(1);
        Account bbb = accountService.findAccountById(2);
        System.out.println("aaa : " + aaa.getMoney());
        System.out.println("bbb : " + bbb.getMoney());

        accountService.transfer("aaa", "bbb", 200);
        aaa = accountService.findAccountById(1);
        bbb = accountService.findAccountById(2);
        System.out.println("aaa : " + aaa.getMoney());
        System.out.println("bbb : " + bbb.getMoney());
    }
}
