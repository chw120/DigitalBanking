package com.onlinebanking.restjaxrs.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onlinebanking.restjaxrs.model.User;
import com.onlinebanking.restjaxrs.service.InitHibernate;

public class UserDao implements UserDaoInterface<User, Long> {
	private static final Logger logger = Logger.getLogger(UserDao.class.getName());

	
	public UserDao() {
	}

	
	public User findUserByEmail(String userEmail) {
		Query query = InitHibernate.openCurrentSession().createQuery("from User u where u.email = :uemail");
		query.setParameter("uemail", userEmail);
		User user = (User) query.getResultList().get(0);
		InitHibernate.closeCurrentSession();
        return user;
	}

    @SuppressWarnings("unchecked")
	public List<User> findAll() {
        List<User> users = (List<User>) InitHibernate.openCurrentSession().createQuery("From User").list();
        InitHibernate.closeCurrentSession();
        return users;
    }
}
