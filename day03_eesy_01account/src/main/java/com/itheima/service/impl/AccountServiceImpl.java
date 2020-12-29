package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService{


    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
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


    public void transfer(String sourceName, String targetName, Float money) {
        try{
            txManager.beginTransaction();
            //根据名称查询转出账号
            Account source = accountDao.findAccountByName(sourceName);
            //根据名称转入账号
            Account target = accountDao.findAccountByName(targetName);
            //转出账号减钱
            source.setMoney(source.getMoney()-money);
            accountDao.updateAccount(source);

            int i = 2/0;

            //转入账号存钱
            target.setMoney(target.getMoney()+money);
            //更新账号

            accountDao.updateAccount(target);

            //提交事务
            txManager.commit();
        }catch (Exception e){
//            执行回滚操作
            txManager.rollback();
            e.printStackTrace();
        }finally {
            //释放连接
            txManager.release();
        }

    }
}
