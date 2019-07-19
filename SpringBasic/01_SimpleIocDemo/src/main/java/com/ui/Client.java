package com.ui;

import com.undermoonoldman.factory.BeanFactory;
import com.undermoonoldman.service.AccountService;


public class Client {
    public static void main(String[] args) {
    	//不论是业务层获取service,还是service获取dao都不用new了,从容器中拿就行了
        AccountService accountService = (AccountService)BeanFactory.getBean("accountService");
        accountService.saveAccount();

    }
}
