package com.jspiders.StudentRegistration.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MachinePOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String Machine_Name;
	String Working_Principle;
	String Tools;

}
