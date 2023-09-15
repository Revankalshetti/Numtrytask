package com.jspiders.StudentRegistration.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.jspiders.StudentRegistration.pojo.MachinePOJO;

@Repository
public class MachineRepository {
	

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
	
	public MachinePOJO addMachine(String machine_Name, String working_Principle, String tools
			) {
		
		Openconnection();
		transaction.begin();
		MachinePOJO machinePOJO=new MachinePOJO();
		machinePOJO.setMachine_Name(machine_Name);
		machinePOJO.setTools(tools);
		machinePOJO.setWorking_Principle(working_Principle);
		manager.persist(machinePOJO);
		transaction.commit();
		CloseConnection();
		
		return machinePOJO;
	}
	
	
	public List<MachinePOJO> findAll() {
		Openconnection();
		transaction.begin();
		jpql="Select M from MachinePOJO M";
		query=manager.createQuery(jpql);
		List <MachinePOJO> pojos= query.getResultList();
		transaction.commit();
		CloseConnection();
		return pojos;
		
	}

	public MachinePOJO find(int id) {
		Openconnection();
		transaction.begin();
		MachinePOJO pojo=manager.find(MachinePOJO.class,id);
		transaction.commit();
		CloseConnection();
		return pojo;
	}

	public MachinePOJO UpdateMachine(int id,String machine_Name, String working_Principle, String tools) {

		Openconnection();
		transaction.begin();
		MachinePOJO pojo=manager.find(MachinePOJO.class,id);
		pojo.setMachine_Name(machine_Name);
		pojo.setTools(tools);
		pojo.setWorking_Principle(working_Principle);
	    manager.persist(pojo);
		transaction.commit();
		CloseConnection();
		return pojo;
	}

	public int Remove(int id) {
	 Openconnection();
	 transaction.begin();
     Removed=0;
     MachinePOJO pojo=manager.find(MachinePOJO.class,id);
     if(pojo !=null) 
      {
    	 manager.remove(pojo);
    	 Removed++;
      }
     transaction.commit();
	 CloseConnection();
	 return Removed;
     	
	}

}
