package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     *
     * @param args
     *
     * 使用单例对象时：对象创建了
     * 对象初始化了。。。
     * service中的saveAccount方法执行了。。。
     * 对象销毁了。。。
     *
     * 使用多例对象时:
     * 对象创建了
     * 对象初始化了。。。
     * service中的saveAccount方法执行了。。。
     *
     * 差别也就是生命周期
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        as.saveAccount();

        //手动关闭容器
        ac.close();
    }
}
