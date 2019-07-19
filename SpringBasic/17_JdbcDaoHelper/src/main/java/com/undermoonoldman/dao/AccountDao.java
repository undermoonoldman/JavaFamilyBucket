package com.undermoonoldman.dao;

import com.undermoonoldman.bean.Account;

public interface AccountDao {
    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);

}
