package com.undermoonoldman.service;

import com.undermoonoldman.bean.Account;
import com.undermoonoldman.dao.AccountDao;
import com.undermoonoldman.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager transactionManager;

    public List<Account> findAllAccount() {
        List<Account> accountList = null;
        try {
            transactionManager.beginTransaction();
            accountList =  accountDao.findAllAccount();
            transactionManager.commitTransaciton();

        } catch (Exception e) {
            transactionManager.rollbackTransaciton();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }
        return accountList;
    }

    public Account findAccountById(Integer accountId) {
        Account account = null;
        try {
            transactionManager.beginTransaction();
            account =  accountDao.findAccountById(accountId);
            transactionManager.commitTransaciton();

        } catch (Exception e) {
            transactionManager.rollbackTransaciton();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }

        return account;
    }

    public void saveAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.saveAccount(account);
            transactionManager.commitTransaciton();

        } catch (Exception e) {
            transactionManager.rollbackTransaciton();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.updateAccount(account);
            transactionManager.commitTransaciton();

        } catch (Exception e) {
            transactionManager.rollbackTransaciton();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            transactionManager.beginTransaction();
            accountDao.deleteAccount(accountId);
            transactionManager.commitTransaciton();

        } catch (Exception e) {
            transactionManager.rollbackTransaciton();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, float money) throws Exception {
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
    }
}
