package com.jspiders.StudentRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jspiders.StudentRegistration.pojo.MachinePOJO;
import com.jspiders.StudentRegistration.repository.MachineRepository;

@Service
public class MachineService {
	
	
	@Autowired
	private MachineRepository repository;

	public MachinePOJO addMachine(String machine_Name, String working_Principle, String tools) {
		
		MachinePOJO pojo=repository.addMachine(machine_Name, working_Principle, tools);
		return pojo;
	}

	public List<MachinePOJO> findAll() {
	    List<MachinePOJO> pojos= repository.findAll();
		return pojos;
	}

	public MachinePOJO find(int id) {
	  MachinePOJO pojo=repository.find(id);
		return pojo;
	}

	public MachinePOJO UpdateMachine(int id,String machine_Name, String working_Principle, String tools) {
	
		MachinePOJO pojo=repository.UpdateMachine(id,machine_Name, working_Principle, tools);
		return pojo;
	}

	public int Remove(int id) {
		int Removed=repository.Remove(id);
		return Removed;
	}

	

}
