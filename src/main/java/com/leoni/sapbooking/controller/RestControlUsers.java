package com.leoni.sapbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.Users;
import com.leoni.sapbooking.service.IServiceUsers;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RestControlUsers {
	@Autowired
	IServiceUsers iServiceUsers;
	// http://localhost:9090/api/registeruser
	//{"id":1 ,"nom":"hamed","email":"hamed.abdallah@gmail.com","password":"leoni123"}
	@PostMapping("/api/registeruser")
	
    public Users registerUser(@RequestBody  Users user) throws Exception{
		
		iServiceUsers.ajouterUsers(user);
		return user;		
}
	//http://localhost:9090/api/allusers	
	 @GetMapping("/api/allusers")
	public List<Users> getAllUsers() {
		return iServiceUsers.getAllUsers();
}
	//http://localhost:9090/api/allusers/23
		 @GetMapping("/api/allusers/{depart}")
	 public List<Users> getselondepart(@PathVariable("depart") Departement depart) {
			return iServiceUsers.getselondepart(depart);
	}
	 
	// URL : http://localhost:9090/api/nom/2
	   @GetMapping(value = "api/nom/{id}")
	
	   public String getEmployePrenomById(@PathVariable("id")int id) {
			return iServiceUsers.getUserNomById(id);
		}
	// URL : http://localhost:9090/api/user/2
	   @GetMapping(value = "api/user/{id}")
	
	   public Users getUserById(@PathVariable("id")int id) {
			return iServiceUsers.getUserById(id);
		}
	    // URL : http://localhost:9090/api/delete/2
	    @DeleteMapping("/api/delete/{id}") 
		public void deleteUsers(@PathVariable("id")int id) {
			 iServiceUsers.deleteUsers(id);
		}
	    // Modifier user : http://localhost:9090/api/maj
	
	 	@PutMapping(value = "/api/maj") 
	 	
	 	public Users update(@RequestBody Users user) {
			
			return iServiceUsers.mettreAjourUsers(user);
			
				
	}
	
		// http://localhost:9090/api/login
				//{"email":"hamed.abdallah@gmail.com","password":"leoni123"}
	 			
				@PostMapping("/api/login")
				
			 	public Users authWithProfile (@RequestBody  Users user) {
			 		String email = user.getEmail();
			 		String password = user.getPassword();
			 		
			 		if(email != null && password !=null) {
			 			user=iServiceUsers.fetchUserByEmailAndPassword(email, password);
			 		}
			 		
			 		return user;
			 	}
}
