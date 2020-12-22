package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 *
 * 曾经XML的配置文件
 * <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 *
 *  scope=""  init-method="" destroy-method="">
 *  <property name=""  value="" | ref=""></property>
 *  </bean>
 *
 *  用于创建对象的：
 *      他们的作用就和XML配置文件编写一个<bean></bean>标签实现的功能一样的
 *      Component：
 *          作用用于把当前类对象存入spring容器中
 *          属性：
 *              Value：用于指定bean的id。当我们不写时它默认的是类名而且首字母必须改小写
 *              Controller：用于表现层
 *              Service:用于业务层
 *              Repository：一般用于持久层
 *              以上三个注解与Component是一模一样的
 *              他们三个是Spring框架为我们提供明确的三层使用的注释，使我们三层对象更清晰
 *
 *  用于注入数据
 *      它们的作用就和zaixml配置文件中的bean标签中写一个<property></property>标签的作用是一样的
 *      Autowired:
 *          作用：自动按照类型注入只要容器中有唯一的bean对象类型和注入类型匹配，就可以自动注入
 *          如果IOC容器中没有任何bean类型要注入的变量类型匹配则报错
 *          如果IOC容器中有多个类型匹配时
 *      出现的位置：
 *          变量  方法
 *       在使用注解注入时，set方法就不再是必须的了
 *
 *       Qualifier：
 *          作用：在按照类中注入的基础之上再按照名称注入。它给类成员注入时不能单独使用
 *          属性：value：用于注入bean的id
 *
 *       Resource:
 *          作用：直接按照bean的id注入。它可以独立使用
 *          属性：
 *              name:用于指定bean的id
 *        上述三个注入数据的注解都只能用来注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *        另外，集合类型的注入只能通过XML来实现
 *
 *        Value:
 *           作用:用于注入基本类型和String类型的数据
 *           属性；
 *              value:用于指定数据的值，他可是使用Spring中的SPEL也就是Spring中el表达式
 *              SpEL的写法：${表达式}
 *
 *         用于改变作用范围
 *         他们的作用就和bean标签中使用SCOPE属性实现的功能是一样的
 *         SCOPE
 *         作用： 用于指定bean的作用范围
 *         属性： value：指定范围的取值，常见的取值Singleton prototype
 *
 *          和生命周其有关
 *              他们的声明周期在bean标签中使用init-method和destroy-methode的作用是一样的
 *
 *             PreDestroy
 *  *          作用：用于指定销毁方法
 *             PostConstruct
 *             作用：用于指定初始化方法
 *
 *
 */
@Service("accountService")
@Scope("prototype")//
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao02")

    @Resource(name = "accountDao02")
    //使用自动注入时如果有两个相同类 型的类，不同属性的类对象时注入那个与这个同名的，，如果只有一个就会默认注入
    private IAccountDao accountDao = null;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }

    @PreDestroy //注意是单例模式，而多例模式不一样
    public void destroy(){
        System.out.println("销毁方法已经执行");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
