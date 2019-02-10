package com.onlinebanking.restjaxrs.service;

import java.util.List;
import java.util.logging.Logger;

import com.onlinebanking.restjaxrs.dao.TransactionDao;
import com.onlinebanking.restjaxrs.dao.UserDao;
import com.onlinebanking.restjaxrs.model.User;

public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	
	private UserDao userDao;

	public UserServiceImpl() {
		this.userDao = new UserDao();
	}

	public User findUserByEmail(String userEmail) {
		User user = userDao.findUserByEmail(userEmail);
		return user;
	}

	public List<User> findAll() {
		List<User> users = userDao.findAll();
		return users;
	}
	
	




}
