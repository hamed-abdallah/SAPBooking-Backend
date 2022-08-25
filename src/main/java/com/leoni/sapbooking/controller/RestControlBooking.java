package com.leoni.sapbooking.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPBooking;
import com.leoni.sapbooking.model.SAPHeureCompensations;
import com.leoni.sapbooking.model.Users;
import com.leoni.sapbooking.service.IServiceSAPBooking;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RestControlBooking {
	@Autowired
	IServiceSAPBooking iServiceSAPBooking;
	
	
	
	//http://localhost:9090/api/allbooking	
		 @GetMapping("/api/allbooking")
		public List<SAPBooking> getallbooking() {
			return iServiceSAPBooking.getallbooking();
	}
		//http://localhost:9090/api/allsap/123456
		 @GetMapping("/api/allsap/{mat}")
	 public List<SAPBooking> getselonmat(@PathVariable("mat") String mat) {
			return iServiceSAPBooking.getselonmat(mat);
	}
			//http://localhost:9090/api/datebook/2020-01-01/2020-03-01
		 @GetMapping("/api/datebook/{mat}/{start}/{end}")
	public List<SAPBooking> getselondate(@PathVariable("mat") String mat,@PathVariable("start") Date start,@PathVariable("end") Date end) {
			return iServiceSAPBooking.getbookselondate(mat,start, end);
	}
		//http://localhost:9090/api/allsap/IT
		 @GetMapping("/api/sapteam/{team}")
	 public List<SAPBooking> getselonteam(@PathVariable("team") String team) {
			return iServiceSAPBooking.getselonteam(team);
	}
		 
}
