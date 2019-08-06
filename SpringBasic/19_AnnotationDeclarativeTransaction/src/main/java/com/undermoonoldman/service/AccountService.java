package com.undermoonoldman.service;

import com.undermoonoldman.bean.Account;

import java.util.List;

public interface  AccountService {

    Account findAccountById(Integer accountId);

    void transfer(String sourceName, String targetName, float money) throws Exception;
}
