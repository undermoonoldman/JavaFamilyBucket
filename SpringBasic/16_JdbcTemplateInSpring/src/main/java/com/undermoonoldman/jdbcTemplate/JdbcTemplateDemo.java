package com.undermoonoldman.jdbcTemplate;

import com.undermoonoldman.bean.Account;
import com.undermoonoldman.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = (AccountDao) ac.getBean("accountDao");


        Account account = accountDao.findAccountById(1);
        System.out.println(account);


        account = accountDao.findAccountByName("bbb");
        System.out.println(account);


        account.setId(10);
        account.setMoney(3000);
        account.setName("ddd");
        accountDao.updateAccount(account);
        account = accountDao.findAccountById(10);
        System.out.println(account);
    }
}
