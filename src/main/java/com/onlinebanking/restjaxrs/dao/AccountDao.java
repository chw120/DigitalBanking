package com.onlinebanking.restjaxrs.dao;

import java.util.List;
import java.util.logging.Logger;

import com.onlinebanking.restjaxrs.model.Account;
import com.onlinebanking.restjaxrs.service.InitHibernate;

public class AccountDao {
	private static final Logger logger = Logger.getLogger(AccountDao.class.getName());

	public AccountDao() {
	}
    
    public void persist(Account account) {
    		InitHibernate.getCurrentSession().save(account);
    }
    
    public void update(Account account) {
    		InitHibernate.getCurrentSession().update(account);
    }
    
    @SuppressWarnings("unchecked")
    public List<Account> findAll() {
        List<Account> accounts = (List<Account>) InitHibernate.openCurrentSession().createQuery("from Account").list();
        InitHibernate.closeCurrentSession();
        return accounts;
    }
 
}
