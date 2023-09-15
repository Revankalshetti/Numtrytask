package com.jspiders.StudentRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.StudentRegistration.pojo.AdminPOJO;
import com.jspiders.StudentRegistration.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired 
	AdminRepository repository;


	public AdminPOJO CreateAdmin(String username, String password) {
		 AdminPOJO pojo	=repository.CreateAdmin(username, password);
		return pojo;
	}


	public AdminPOJO findAdmin(String username,String password) {
     return repository.findAdmin(username,password);
	}


	public  AdminPOJO finduser(String username) {
	   return repository.finduser(username);
	
	}
	
}
