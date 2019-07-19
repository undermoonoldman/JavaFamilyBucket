package com.undermoonoldman.dao;

public class AccountDaoImpl implements AccountDao {
    public AccountDaoImpl() {
        System.out.println("AccountDaoImpl对象创建了");
    }

    public void saveAccount() {
        System.out.println("保存成功！");
    }
}
