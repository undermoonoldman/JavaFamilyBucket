package com.undermoonoldman.service;

import com.undermoonoldman.bean.Account;

import java.util.List;

public interface  AccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    void transfer(String sourceName, String targetName, float money);
}
