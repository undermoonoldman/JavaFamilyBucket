package com.undermoonoldman.factory;

import com.undermoonoldman.service.AccountService;
import com.undermoonoldman.service.AccountServiceImpl;
import com.undermoonoldman.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {

    @Autowired
    private AccountService accountService;

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    private TransactionManager transactionManager;

    public AccountService getAccountService() throws Exception {
        return (AccountService) Proxy.newProxyInstance(AccountServiceImpl.class.getClassLoader(), AccountServiceImpl.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    transactionManager.beginTransaction();
                    returnValue = method.invoke(accountService, args);
                    transactionManager.commitTransaciton();
                } catch (Exception e) {
                    transactionManager.rollbackTransaciton();
                    e.printStackTrace();
                } finally {
                    transactionManager.release();
                }
                return returnValue;
            }
        });
    }
}

