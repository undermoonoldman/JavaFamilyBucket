package com.undermoonoldman.factory;

import com.undermoonoldman.service.AccountService;
import com.undermoonoldman.service.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getService(){
        return new AccountServiceImpl();
    }
}
