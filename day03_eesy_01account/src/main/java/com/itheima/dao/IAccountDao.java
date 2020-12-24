package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    //    查询所有
    List<Account> findAllAccount();

    //    根据id查询
    Account findAccountById(Integer id);

    //    保存
    void saveAccount(Account account);

    //    更新
    void updateAccount(Account account);

    //    删除
    void deleteAccount(Integer accountId);

    Account findAccountByName(String accountName);
}
