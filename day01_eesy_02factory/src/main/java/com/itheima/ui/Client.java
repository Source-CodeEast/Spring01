package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImp;

public class Client {
    public static void main(String[] args) {
        for(int i=0;i<5;i++) {
            IAccountService as = new AccountServiceImp();
//            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
