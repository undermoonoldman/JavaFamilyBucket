package com.undermoonoldman.service;


public class AccountServiceImpl implements AccountService {
    public void init(){
        System.out.println("初始化");
    }

    public void destory(){
        System.out.println("销毁");
    }

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl对象创建了");
    }

    public void saveAccount() {
        System.out.println("保存成功了！");
    }
}
