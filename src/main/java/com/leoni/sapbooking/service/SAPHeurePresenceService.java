package com.leoni.sapbooking.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPHeurePresence;
import com.leoni.sapbooking.repository.SAPHeurePresenceRepository;

@Service
public class SAPHeurePresenceService implements IServiceSAPHeurePresence{
	@Autowired
	SAPHeurePresenceRepository sapHeurePresenceRepository;
	public List<SAPHeurePresence> getallheurepresence(){
		return (List<SAPHeurePresence>) sapHeurePresenceRepository.findAll();
	}
	public List<SAPHeurePresence>	getheureselonmat(String mat){
		List<SAPHeurePresence> sap =sapHeurePresenceRepository.findByMatriculeRH(mat);
		return sap ;
	}
		public List<SAPHeurePresence> getselondate (String mat, Date stardate ,Date enddate){
			List<SAPHeurePresence> presence=sapHeurePresenceRepository.findByMatriculeRHAndDateBetween(mat,stardate, enddate);
					return presence ;
		}
	}
	

