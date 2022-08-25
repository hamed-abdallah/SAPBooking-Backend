package com.leoni.sapbooking.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPHeurePresence;

import com.leoni.sapbooking.service.IServiceSAPHeurePresence;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RestControlHeurePresence {
	@Autowired
	IServiceSAPHeurePresence iServiceSAPHeurePResence;
	
	//http://localhost:9090/api/allheurepres
	 @GetMapping("/api/allheurepres")
	public List<SAPHeurePresence> getallheurepresence() {
		return iServiceSAPHeurePResence.getallheurepresence();
}
	//http://localhost:9090/api/heurepres/123456
	 @GetMapping("/api/heurepres/{mat}")
public List<SAPHeurePresence> getheureselonmat(@PathVariable("mat") String mat) {
		return iServiceSAPHeurePResence.getheureselonmat(mat);
}
		//http://localhost:9090/api/date/2020-01-01/2020-03-01
	 @GetMapping("/api/date/{mat}/{start}/{end}")
public List<SAPHeurePresence> getselondate(@PathVariable("mat") String mat,@PathVariable("start") Date start,@PathVariable("end") Date end) {
		return iServiceSAPHeurePResence.getselondate(mat,start, end);
}
	 
	
}
