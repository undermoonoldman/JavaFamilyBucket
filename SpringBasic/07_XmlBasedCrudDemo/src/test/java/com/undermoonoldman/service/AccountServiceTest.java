package com.undermoonoldman.service;


import com.undermoonoldman.bean.Account;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void testFindAll(){
        AccountService as = (AccountService) ac.getBean("accountService");
        List<Account> accountList = as.findAllAccount();
        System.out.println(accountList);
    }

    @Test
    public void testFindOne(){
        AccountService as = (AccountService) ac.getBean("accountService");
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1000);
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount(account);
        account = as.findAccountById(4);
        System.out.println(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(4);
        account.setName("eee");
        account.setMoney(2000);
        AccountService as = (AccountService) ac.getBean("accountService");
        as.updateAccount(account);
        account = as.findAccountById(4);
        System.out.println(account);
    }

    @Test
    public void testDelete(){
        AccountService as = (AccountService) ac.getBean("accountService");
        as.deleteAccount(4);
        List<Account> accountList = as.findAllAccount();
        System.out.println(accountList);
    }
}
