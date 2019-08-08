package com.undermoonoldman.dao;

import com.undermoonoldman.bean.Account;
import com.undermoonoldman.bean.AccountUser;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    /**查询所有账户信息顺便关联用户信息*/
    List<AccountUser> findAllAccount();

    Account findAccountByUserId(Integer userid);
}
