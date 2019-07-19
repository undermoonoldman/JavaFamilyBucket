package com.undermoonoldman.dao.impl;

import com.undermoonoldman.bean.Account;
import com.undermoonoldman.dao.AccountDao;
import com.undermoonoldman.jdbcTemplate.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(Integer accountId) {
        return jdbcTemplate.query("select * from account where id = ?", new AccountRowMapper(), accountId).get(0);
    }

    public Account findAccountByName(String accountName) {
        return jdbcTemplate.query("select * from account where name = ?", new AccountRowMapper(), accountName).get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
