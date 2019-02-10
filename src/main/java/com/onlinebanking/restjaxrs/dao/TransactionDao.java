package com.onlinebanking.restjaxrs.dao;

import java.util.logging.Logger;

import com.onlinebanking.restjaxrs.model.Transaction;
import com.onlinebanking.restjaxrs.service.InitHibernate;

public class TransactionDao {
	private static final Logger logger = Logger.getLogger(TransactionDao.class.getName());


	public void persist(Transaction transaction) {
		InitHibernate.getCurrentSession().save(transaction);
	}
}
