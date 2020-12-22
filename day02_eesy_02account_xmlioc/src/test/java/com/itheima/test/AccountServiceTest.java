package com.itheima.test;

//    使用junit单元；测试我们的配置

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    //获取容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    //获取业务层对象
    IAccountService iAccountService = ac.getBean("accountService",IAccountService.class);

    @Test
    public void testFind(){
        List<Account> account = iAccountService.findAllAccount();
        for (Account a:account) {
            System.out.println(a);
        }
    }

    @Test
    public void testFindOne(){
        Account account = iAccountService.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(124f);

        iAccountService.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        Account account = iAccountService.findAccountById(3);
        account.setMoney(213f);
        iAccountService.updateAccount(account);
    }
    @Test
    public void testDelete(){
        iAccountService.deleteAccount(4);
    }

}
