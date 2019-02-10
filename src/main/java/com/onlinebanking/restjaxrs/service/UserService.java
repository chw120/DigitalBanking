package com.onlinebanking.restjaxrs.service;

import java.util.List;

import com.onlinebanking.restjaxrs.model.User;

public interface UserService {

	User findUserByEmail(String userEmail);
	
	List<User> findAll();

}
