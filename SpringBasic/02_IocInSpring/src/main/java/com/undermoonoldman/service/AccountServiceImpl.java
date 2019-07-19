package com.undermoonoldman.service;

import com.undermoonoldman.dao.AccountDao;
import com.undermoonoldman.dao.AccountDaoImpl;
import com.undermoonoldman.factory.BeanFactory;

public class AccountServiceImpl implements AccountService {
    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl对象创建了");
    }

    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
