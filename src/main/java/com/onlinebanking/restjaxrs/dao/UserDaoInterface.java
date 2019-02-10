package com.onlinebanking.restjaxrs.dao;

import java.io.Serializable;
import java.util.List;

import com.onlinebanking.restjaxrs.model.User;

public interface UserDaoInterface<T, Id extends Serializable> {

	public List<User> findAll();
	
	public User findUserByEmail(String userEmail);
}
