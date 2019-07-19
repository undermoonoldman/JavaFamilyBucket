package com.undermoonoldman.dao.impl;

import com.undermoonoldman.bean.Account;
import com.undermoonoldman.dao.AccountDao;
import com.undermoonoldman.jdbcTemplate.AccountRowMapper;

/**其实Spring中有JdbcTemplate了,在使用是不用自己做实现.使用接口的方式可以方便加注解,而继承因为了JdbcDaoSupport所以不用在引入JdbcTemplate了,但是同样的也失去了注解开发的能力,只能使用XML来进行配置*/
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    public Account findAccountById(Integer accountId) {
        return getJdbcTemplate().query("select * from account where id = ?", new AccountRowMapper(), accountId).get(0);
    }

    public Account findAccountByName(String accountName) {
        return getJdbcTemplate().query("select * from account where name = ?", new AccountRowMapper(), accountName).get(0);
    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
