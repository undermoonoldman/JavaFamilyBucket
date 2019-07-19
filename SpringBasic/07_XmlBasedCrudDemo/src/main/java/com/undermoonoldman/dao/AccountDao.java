package com.undermoonoldman.dao;


import com.undermoonoldman.bean.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
