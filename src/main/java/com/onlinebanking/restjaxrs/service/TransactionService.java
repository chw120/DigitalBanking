package com.onlinebanking.restjaxrs.service;

import java.math.BigDecimal;

import com.onlinebanking.restjaxrs.model.Account;

public interface TransactionService {

	boolean transferOnetime(Account accountFrom, Account accountTo, BigDecimal amount);

}
