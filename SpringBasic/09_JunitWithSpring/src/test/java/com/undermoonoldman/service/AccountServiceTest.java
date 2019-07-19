package com.undermoonoldman.service;


import com.undermoonoldman.bean.Account;
import com.undermoonoldman.config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AccountService accountService;

    @Test
    public void testFindAll(){
        List<Account> accountList = accountService.findAllAccount();
        System.out.println(accountList);
    }

    @Test
    public void testFindOne(){
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1000);
        accountService.saveAccount(account);
        account = accountService.findAccountById(6);
        System.out.println(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(6);
        account.setName("eee");
        account.setMoney(2000);
        accountService.updateAccount(account);
        account = accountService.findAccountById(6);
        System.out.println(account);
    }

    @Test
    public void testDelete(){
        accountService.deleteAccount(6);
        List<Account> accountList = accountService.findAllAccount();
        System.out.println(accountList);
    }
}
