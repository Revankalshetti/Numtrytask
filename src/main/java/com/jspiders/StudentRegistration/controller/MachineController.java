
package com.jspiders.StudentRegistration.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.jspiders.StudentRegistration.pojo.AdminPOJO;
import com.jspiders.StudentRegistration.pojo.MachinePOJO;
import com.jspiders.StudentRegistration.service.AdminService;
import com.jspiders.StudentRegistration.service.MachineService;

@Controller
public class MachineController {
	@Autowired
	private MachineService service;
	@Autowired
	private AdminService service2;
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="login" ,required=false)AdminPOJO login,ModelMap  map) {
		if(login !=null) {
		return "Home";
	 }else {
		 map.addAttribute("msg","please login to proceed...!");
		 return "Login";
	 }
	}
	
	
	@GetMapping("/add")
	public String Add(@SessionAttribute(name="login" ,required=false)AdminPOJO login,ModelMap  map) {
		if(login !=null) {
		return "Add";
		}else{
			 map.addAttribute("msg","please login to proceed...!");
			 return "Login";
		 }
	}
	
	@PostMapping("/add")
	public String add(  @RequestParam String Machine_Name,
						@RequestParam String Working_Principle,
						@RequestParam String Tools,
						@SessionAttribute(name="login" ,required=false)AdminPOJO login,
						ModelMap map) {
		if(login !=null) {
	    MachinePOJO pojo= service.addMachine(Machine_Name,Working_Principle,Tools);
	    
		if (pojo != null && pojo.getMachine_Name()!=null ) {
			//Success response
			map.addAttribute("msg", "Data added successfully..!!");
			return "Add";
			}
	     
		map.addAttribute("msg", "Data not added successfully..!!");
		return "Add";
		}
		else{
			 map.addAttribute("msg","please login to proceed...!");
			 return "Login";
		 }
	}
	
	

	@GetMapping("/update")
	public String Update(ModelMap map,@SessionAttribute(name="login" ,required=false)AdminPOJO login) {
		if(login !=null) {
		List <MachinePOJO> pojos=service.findAll();
		
		map.addAttribute("POJOS",pojos);
	    return "Update";
	}else{
		 map.addAttribute("msg","please login to proceed...!");
		 return "Login";
	 }
	}
	
	@PostMapping("/update")
	public String Update1(ModelMap map,@RequestParam int id,@SessionAttribute(name="login" ,required=false)AdminPOJO login) {
		  
		if(login !=null) {
		  MachinePOJO pojo= service.find(id); 
		  map.addAttribute("pojo",pojo);
	     return "Update1";
	}else{
		 map.addAttribute("msg","please login to proceed...!");
		 return "Login";
	 }
	}
	
	@PostMapping("/updatemachine")
	public String UpdateMachine(
			            @RequestParam int id,
			            @RequestParam String Machine_Name,
						@RequestParam String Working_Principle,
						@RequestParam String Tools,
						@SessionAttribute(name="login" ,required=false)AdminPOJO login,
						ModelMap map) {
		if(login !=null) {
	    MachinePOJO pojo= service.UpdateMachine(id,Machine_Name,Working_Principle,Tools);
       List <MachinePOJO> pojos=service.findAll();
		map.addAttribute("POJOS",pojos);
	    
		if (pojo != null ) {
			//Success response
			map.addAttribute("msg", "Data Updated successfully..!!");
			return "Update";
			}
	     
		map.addAttribute("msg", "Data not Updated successfully..!!");
		map.addAttribute("POJOS",pojos);
	    
		return "Update";
		}else {
			 map.addAttribute("msg","please login to proceed...!");
			 return "Login";
		}
	}
	
	@GetMapping("/remove")
	
	public String Remove(ModelMap map,@SessionAttribute(name="login" ,required=false)AdminPOJO login)
	{
		if(login !=null) {
		 List <MachinePOJO> pojos=service.findAll();
		 map.addAttribute("POJOS",pojos);
		 return "Remove";
	}else {map.addAttribute("msg","please login to proceed...!");
	 return "Login";
	}
	}
	
	@PostMapping("/remove")
	public String RemoveID(ModelMap map,@RequestParam int id,@SessionAttribute(name="login" ,required=false)AdminPOJO login) {
		if(login!=null)
		{
		if(id>0) {
		int Removed=service.Remove(id);
		   List <MachinePOJO> pojos=service.findAll();
			
		if(Removed >0) {
		map.addAttribute("remove",Removed+" DATA HAS REMOVED SUCCESFULLY");
		map.addAttribute("POJOS",pojos);
		return "Remove";
		}
		map.addAttribute("remove","DATA IS NOT REMOVED");
		map.addAttribute("POJOS",pojos);
		return "Remove";
	}
	else {
		map.addAttribute("remove","DATA IS NOT REMOVED");
        List<MachinePOJO> pojos=service.findAll();
		map.addAttribute("POJOS",pojos);
		return "Remove";

	}
	}else {
		map.addAttribute("msg","please login to proceed...!");
		 return "Login";
	}
  }
	
	@GetMapping("/search")
	public String Search(ModelMap map,@SessionAttribute(name="login" ,required=false)AdminPOJO login) {
		if(login !=null) {
		List <MachinePOJO> pojos=service.findAll();
		map.addAttribute("POJOS",pojos);
		
		return "Search";
	}else {
		map.addAttribute("msg","please login to proceed...!");
		 return "Login";
		}
	}
	
    @PostMapping("/search")
    public String SearchID(ModelMap map,@RequestParam int id,@SessionAttribute(name="login" ,required=false)AdminPOJO login) {
    	if(login !=null) {
		MachinePOJO pojo=service.find(id);
		List <MachinePOJO> pojos=service.findAll();
		map.addAttribute("POJOS",pojos);
		
		if(pojo ==null) {
			map.addAttribute("msg","ENTER THE RIGHT ID NO");
			return "Search";
		}
		map.addAttribute("POJOS",pojos);
		
		map.addAttribute("pojo",pojo);
		return "Search";
	}else {
		map.addAttribute("msg","please login to proceed...!");
		 return "Login";
	}
}
    @GetMapping("/logout")
    public String Logout(ModelMap map,HttpSession session) {
    	session.invalidate();
    	map.addAttribute("msg","...YOU HAVE LOGGEDOUT SUCCESSFULLY...!!");
    	return "Login";
    }
    
    @GetMapping("/createaccount")
    public String CreateAccount(ModelMap map) {
    	
    	    return "Createaccount";
    	
    }
    
    @PostMapping("/createaccount")
    public String Create1(@RequestParam String username,@RequestParam String password,ModelMap map)
    {
         if( service2.finduser(username)!=null) {
        	 
        	 map.addAttribute("msg","The Accout is Already present	..!");
        	 return "Login";
         }   	
    	
    	 AdminPOJO pojo1=service2.CreateAdmin(username,password);
    	
    	if(pojo1 !=null) {
    	map.addAttribute("msg","The Accout created Succesfully...!");
      	return "Login";
    	}else {
    	map.addAttribute("msg","The Accout IS  NOT CREATED....!");
    	return "Login";
    }
  
  }
    
    @PostMapping("/login")
    public String LoginAdmin(@RequestParam String username,@RequestParam String password,ModelMap map,HttpServletRequest request)
    {
    	AdminPOJO pojo=(AdminPOJO)service2.findAdmin(username,password);
   	 if(pojo==null) {
   		map.addAttribute("msg","Invalid user name or the pasword");
   		return "Login";
   	 }
   	HttpSession session = request.getSession();
   	session.setAttribute("login",pojo);
     return "Home";
    }
}  

 