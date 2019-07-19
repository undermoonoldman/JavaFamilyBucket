package com.undermoonoldman.dao;


import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    public AccountDaoImpl() {
        System.out.println("创建Dao对象!");
    }

    @PostConstruct
    public void init(){
        System.out.println("dao init method!");
    }

    @PreDestroy
    public void destory(){
        System.out.println("dao destory method!");
    }

    public void saveAccount() {
        System.out.println("save account!");
    }
}
