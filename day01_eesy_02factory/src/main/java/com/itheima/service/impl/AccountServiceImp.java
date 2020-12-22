package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

public class AccountServiceImp implements IAccountService {

    private  IAccountDao accountDao = new AccountDaoImpl();

//    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

//    private static IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
//    private int i = 1;

    public void  saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
//    public void saveAccount(){
//        IAccountDao accountDao = new AccountDaoImpl();
//        accountDao.saveAccount();
//    }
}
