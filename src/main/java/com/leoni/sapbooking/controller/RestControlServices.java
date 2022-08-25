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
import org.springframework.web.bind.annotation.RestController;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.Users;
import com.leoni.sapbooking.service.IServiceUsers;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RestControlServices {
	@Autowired
	IServiceUsers iServiceUsers;
	
	// http://localhost:9090/api/ajoutdepart
		//{"id":1 ,"servicenom":"IT"}
		@PostMapping("/api/ajoutdepart")
	
	 public Departement registerUser(@RequestBody  Departement departement) throws Exception{
			
			iServiceUsers.ajouterService(departement);
			return departement;		
	}
		//http://localhost:9090/api/alldepart	
		 @GetMapping("/api/alldepart")
		public List<Departement> getAllDepartement() {
			return iServiceUsers.getAllDepartement();
	}
		 // Modifier depart : http://localhost:9090/api/majdepart
		 //{"departnom":"IT"}
		 	@PutMapping(value = "/api/majdepart") 
		 	
		 	public Departement update(@RequestBody Departement depart) {
				iServiceUsers.mADepartById(depart);
				return depart;
					
		}
		 // URL : http://localhost:9090/api/deletedepart/2
		    @DeleteMapping("/api/deletedepart/{id}")
		public void deletedepartement(@PathVariable("id")int id) {
			iServiceUsers.deleteDepart(id);
		}
		 
}
