package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {


    private QueryRunner queryRunner;
    private ConnectionUtils connectionUtils;


    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class)); //待会理解一下这里是什么意思为什么要传入Account的字节么文件
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Account findAccountById(Integer accountId) {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
//            throwables.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"insert into account(name,money) value(?,?)",account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException();
        }

    }

    public void updateAccount(Account account) {
        try{
            queryRunner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            queryRunner.update(connectionUtils.getThreadConnection(),"delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where name =?", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts==null || accounts.size()==0)return null;
            if (accounts.size()>1) throw new RuntimeException("结果集不唯一");
            else return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}

