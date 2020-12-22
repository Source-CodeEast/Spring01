package com.itheima.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void testQueryTest(){
//        获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取QueryRunner
        QueryRunner runner = applicationContext.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = applicationContext.getBean("runner",QueryRunner.class);
        System.out.println(runner);
        System.out.println(runner1);
    }
}
