package com.onlinebanking.restjaxrs.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InitHibernate {

	private static Session currentSession;    
    private static Transaction currentTransaction;
    private static SessionFactory sessionFactory;

	public static Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public static Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public static void closeCurrentSession() {
        currentSession.close();
    }
     
    public static void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
	    	if (sessionFactory == null) {
	        Configuration configuration = new Configuration().configure();
	        sessionFactory = configuration.buildSessionFactory();
	    	}
        return sessionFactory;
    }
    
    public static Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
}
