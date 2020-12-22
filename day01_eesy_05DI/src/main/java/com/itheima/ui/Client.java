package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        IAccountService as2  = (IAccountService)ac.getBean("accountService02");
        IAccountService as3  = (IAccountService)ac.getBean("accountService03");


        as.saveAccount();
        as2.saveAccount();
        as3.saveAccount();

        //手动关闭容器
        ac.close();
    }
}
