package com.itheima.dao.Impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDao implements IAccountDao {

    //用来执行sql语句的类
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner){
        this.queryRunner = queryRunner;
    }


    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class)); //待会理解一下这里是什么意思为什么要传入Account的字节么文件
        } catch (Exception e) {
//            throwables.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public Account findAccountById(Integer accountId) {
        try {
            return queryRunner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
//            throwables.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
    try {
        queryRunner.update("insert into account(name,money) value(?,?)",account.getName(),account.getMoney());
    }catch (Exception e){
        throw new RuntimeException();
    }

    }

    public void updateAccount(Account account) {
        try{
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            queryRunner.update("delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
