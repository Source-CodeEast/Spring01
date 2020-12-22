package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * APPlication三个实现类
 *
 * classPathXmlApplicationContext:可以加载类路径下的配置文件
 * FileSystemXmlApplication:它可以加载磁盘任意路径下的配置文件（必要有访问权限
 * AnnotationConfigApplicationContext:它是用于读取注解创建容器的
 * */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器
        /**
         * 获取核心容器有两个接口
         *
         * 1。ApplicationContext
         *      在构建核心容器时，创建对象采用立即加载的方式，也就是说在读取配置文件后就会立即创建对象
         * 2.BeanFactory: 多例对象使用
         *      它构建核心容器时创建对象采用延迟加载策略也就是在使用id获取对象时才会真正创建对象
         * */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //使用磁盘路径进行
        //        ApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("C:\\Users\\26954\\OneDrive\\桌面\\bean.xml");
        //2.根据id获取bean对象
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
//        也可以使用另外一种方式进行创建.第一种使用反射进行创建，第二种使用获取bean工厂中的值进行创建
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        System.out.println(accountDao);
        System.out.println(accountService);

        accountService.savaAccount();

        //-----BeanFactory-------

//        Resource rs = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(rs);
//        IAccountService as = (IAccountService) factory.getBean("accountService");
//        System.out.println(as);

    }
}
