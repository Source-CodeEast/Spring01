package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

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

    /**
     * 转账
     *
     * */
    void transfer(String sourceName,String targetName,Float money);


}
