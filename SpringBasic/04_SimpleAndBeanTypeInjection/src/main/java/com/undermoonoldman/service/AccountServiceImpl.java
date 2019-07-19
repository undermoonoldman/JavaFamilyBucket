package com.undermoonoldman.service;


import java.util.Date;

public class AccountServiceImpl implements AccountService {

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private String name;

    private Integer age;

    private Date birthday;

//    public AccountServiceImpl(String name, Integer age, Date birthday) {
//        this.name = name;
//        this.age = age;
//        this.birthday = birthday;
//    }

    public void saveAccount() {
        System.out.println("保存成功了！" + name + ", " + age + ", " + birthday);
    }
}
