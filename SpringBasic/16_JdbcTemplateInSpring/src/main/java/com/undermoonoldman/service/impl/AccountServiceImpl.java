package com.undermoonoldman.service.impl;

import com.undermoonoldman.service.AccountService;
import org.springframework.stereotype.Component;

@Component("accountService")
public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("saved !");
    }

    public void updateAccount(int i) {
        System.out.println("updated !");
    }


    public int deleteAccount() {
        System.out.println("deleted !");
        return 0;
    }

}
