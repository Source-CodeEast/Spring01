package com.itheima.service.Impl;
import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

/**
 * 业务层实现类  要用来操作持久层数据
 * */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
