package com.leoni.sapbooking.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoni.sapbooking.repository.SAPBookingRepository;
import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPBooking;
import com.leoni.sapbooking.model.SAPHeureCompensations;
import com.leoni.sapbooking.model.Users;
@Service
public class SAPBookinkService implements IServiceSAPBooking{
	@Autowired
	SAPBookingRepository 	sapBookingRepository ;
	
	public List<SAPBooking> getallbooking(){
		return (List<SAPBooking>) sapBookingRepository.findAll();
	}
	public List<SAPBooking>	getselonmat(String mat){
		List<SAPBooking> sap =sapBookingRepository.findByPersNum(mat);
		return sap ;
	}
	public List<SAPBooking> getbookselondate (String mat,Date stardate ,Date enddate){
		List<SAPBooking> comp=sapBookingRepository.findByPersNumAndDateBetween(mat,stardate, enddate);
		return comp ;
	}
	public List<SAPBooking>	getselonteam(String team){
		List<SAPBooking> sap =sapBookingRepository.findByTeam(team);
		return sap ;
	}
	
}
