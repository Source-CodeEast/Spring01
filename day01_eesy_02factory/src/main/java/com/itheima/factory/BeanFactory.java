package com.itheima.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties;
    //定义一个map用来存储对象。称之为容器
    private static Map<String,Object> beans;
    //使用静态代码块为porperties赋值
    static {
        try{
            //创建实例化对象
            properties = new Properties();
            //获取properties文件的流对象
            BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中的所有key
            Enumeration<Object> keys = properties.keys();

            //遍历枚举
            while (keys.hasMoreElements()){
    //        取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化失败");
        }
    }
    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根据Bean的名称获取bean对象
     * @param beanName
     * @return

    public static Object getBean(String beanName){
    Object bean = null;
    try {
    String beanPath = props.getProperty(beanName);
    //            System.out.println(beanPath);
    bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
    }catch (Exception e){
    e.printStackTrace();
    }
    return bean;
    }*/
}
