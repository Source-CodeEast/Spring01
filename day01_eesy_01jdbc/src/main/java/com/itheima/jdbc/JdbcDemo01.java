package com.itheima.jdbc;

import java.sql.*;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.注册连接
        Class.forName("com.mysql.cj.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "2695446772qq");
        //3.获取数据库预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }


}
