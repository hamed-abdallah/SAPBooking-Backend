package com.leoni.sapbooking.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.leoni.sapbooking.model.SAPHeureCompensations;
import com.leoni.sapbooking.model.SAPHeurePresence;
import com.leoni.sapbooking.service.IServiceSAPHeureCompensations;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RestControlHeureCompensations {
	@Autowired
	IServiceSAPHeureCompensations iServiceSAPHeureCompensations;
	
	//http://localhost:9090/api/allheurecomp
		 @GetMapping("/api/allheurecomp")
	public List<SAPHeureCompensations> getallheurecompensations() {
		return iServiceSAPHeureCompensations.getallheurecompensations();
}
	//http://localhost:9090/api/heurecomp/123456
	 @GetMapping("/api/heurecomp/{mat}")
public List<SAPHeureCompensations> getheureselonmat(@PathVariable("mat") String mat) {
		return iServiceSAPHeureCompensations.getcompselonmat(mat);
}
		//http://localhost:9090/api/datecomp/2020-01-01/2020-03-01
	 @GetMapping("/api/datecomp/{mat}/{start}/{end}")
public List<SAPHeureCompensations> getselondate(@PathVariable("mat") String mat,@PathVariable("start") Date start,@PathVariable("end") Date end) {
		return iServiceSAPHeureCompensations.getcompselondate(mat,start, end);
}
	
}
