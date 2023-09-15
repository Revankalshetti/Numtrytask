package com.jspiders.StudentRegistration.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.jspiders.StudentRegistration.pojo.AdminPOJO;

@Repository
public class AdminRepository {

	

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;
	private int Removed;
	
	private static void Openconnection() {
		factory=Persistence.createEntityManagerFactory("emp");
		
		manager = factory.createEntityManager();
		
		transaction=manager.getTransaction();
		
	}
	
	private static void CloseConnection() {
	 
		if(factory !=null) {
			factory.close();
		}if(manager !=null) {
			manager.close();
		}if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public  AdminPOJO CreateAdmin(String username, String password) {
		Openconnection();
		transaction.begin();
		
		AdminPOJO pojo=new AdminPOJO();
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		CloseConnection();
		return pojo;
	}
	
	public AdminPOJO findAdmin(String username,String passoword) {
	    Openconnection();
	    transaction.begin();
	    jpql = "FROM AdminPOJO WHERE username= '"+username+"' and password='"+passoword+"'";
	    query = manager.createQuery(jpql);
	   List< AdminPOJO >pojos = (List< AdminPOJO >) query.getResultList();
	   for(AdminPOJO pojo:pojos) {
		   transaction.commit();
		    CloseConnection();
		   return pojo;
	   }
	    transaction.commit();
	    CloseConnection();
	    return null;
	}

	public AdminPOJO finduser(String username) {
		
		Openconnection();
	    transaction.begin();
	    jpql = "FROM AdminPOJO WHERE username= '"+username+"'";
	    query = manager.createQuery(jpql);
	   List< AdminPOJO >pojos = (List< AdminPOJO >) query.getResultList();
	   for(AdminPOJO pojo:pojos) {
		   transaction.commit();
		    CloseConnection();
		   return pojo;
	   }
	    transaction.commit();
	    CloseConnection();
	    return null;
		
	}


}
