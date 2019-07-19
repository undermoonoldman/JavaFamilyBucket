package com.undermoonoldman.service;

import com.undermoonoldman.dao.AccountDao;
import com.undermoonoldman.dao.AccountDaoImpl;
import com.undermoonoldman.factory.BeanFactory;

public class AccountServiceImpl implements AccountService {
	//没有容器之前要使用new的方法创建所依赖的对象
//    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao;
    public void saveAccount() {
    	//有了容器之后从容器中获取所依赖的对象就可以了
        accountDao = (AccountDao) BeanFactory.getBean("accountDao");
        accountDao.saveAccount();
    }
}
