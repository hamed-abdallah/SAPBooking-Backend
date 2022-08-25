package com.leoni.sapbooking.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoni.sapbooking.model.SAPHeureCompensations;
import com.leoni.sapbooking.model.SAPHeurePresence;
import com.leoni.sapbooking.repository.SAPHeureCompensationsRepository;

@Service
public class SAPHeureCompensationsService implements IServiceSAPHeureCompensations {
	@Autowired
	SAPHeureCompensationsRepository sapHeurecompensationRepository;
	
	public List<SAPHeureCompensations> getallheurecompensations(){
		return (List<SAPHeureCompensations>) sapHeurecompensationRepository.findAll();
	}
	public List<SAPHeureCompensations>	getcompselonmat(String mat){
		List<SAPHeureCompensations> sap =sapHeurecompensationRepository.findByMatriculeRH(mat);
		return sap ;
	}
	public List<SAPHeureCompensations> getcompselondate (String mat ,Date stardate ,Date enddate){
		List<SAPHeureCompensations> comp=sapHeurecompensationRepository.findByMatriculeRHAndDateBetween(mat,stardate, enddate);
		return comp ;
	}
}
