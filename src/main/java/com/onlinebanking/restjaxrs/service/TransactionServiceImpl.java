package com.onlinebanking.restjaxrs.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.onlinebanking.restjaxrs.dao.AccountDao;
import com.onlinebanking.restjaxrs.dao.TransactionDao;
import com.onlinebanking.restjaxrs.model.Account;
import com.onlinebanking.restjaxrs.model.Transaction;
import com.onlinebanking.restjaxrs.model.TransactionType;

public class TransactionServiceImpl implements TransactionService {
	private static final Logger logger = Logger.getLogger(TransactionServiceImpl.class.getName());

	
	private AccountDao accountDao;
	private TransactionDao transactionDao;
	
	public TransactionServiceImpl() {
		this.accountDao = new AccountDao();
		this.transactionDao = new TransactionDao();
	}

	public boolean transferOnetime(Account accountFrom, Account accountTo, BigDecimal amount) {
		InitHibernate.openCurrentSessionwithTransaction();
		accountTo.setAccountBalance(accountTo.getAccountBalance().add(amount));
		accountFrom.setAccountBalance(accountFrom.getAccountBalance().subtract(amount));
		Transaction t1 = new Transaction();
		t1.setAmount(new BigDecimal(0).subtract(amount));
		t1.setAvailableBalance(accountFrom.getAccountBalance());
		t1.setDate(new Date());
		t1.setNotes("Transfer money to " + accountTo.getUser().getEmail());
		t1.setStatus("Success");
		t1.setTransactionType(TransactionType.ONE_TIME);
		transactionDao.persist(t1);
		t1.setAmount(amount);
		t1.setAvailableBalance(accountTo.getAccountBalance());
		t1.setDate(new Date());
		t1.setNotes("Got money from " + accountFrom.getUser().getEmail());
		t1.setStatus("Success");
		t1.setTransactionType(TransactionType.ONE_TIME);
		transactionDao.persist(t1);
		accountDao.update(accountTo);
		accountDao.update(accountFrom);
		InitHibernate.closeCurrentSessionwithTransaction();
		List<Account> a = accountDao.findAll();
		for (Account i : a) {
			System.out.println(i.getAuid() + " " + i.getAccountBalance());
		}
		return true;
	}

}
