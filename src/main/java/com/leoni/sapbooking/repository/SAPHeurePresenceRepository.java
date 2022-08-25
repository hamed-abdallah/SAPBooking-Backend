package com.leoni.sapbooking.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPHeurePresence;


public interface SAPHeurePresenceRepository extends JpaRepository< SAPHeurePresence , Integer> {
	
	List<SAPHeurePresence> findByMatriculeRH(String mat);
List<SAPHeurePresence> findByMatriculeRHAndDateBetween(String mat,Date stardate, Date enddate);
	
}
