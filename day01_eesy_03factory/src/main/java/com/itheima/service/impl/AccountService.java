package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImp;
import com.itheima.service.IAccountService;

public class AccountService implements IAccountService {

    private IAccountDao accountDao ;

    public AccountService(){
        accountDao = new AccountDaoImp();
        System.out.println("对象创建了");
    }
    public void savaAccount() {
        accountDao.saveAccount();

    }
}
