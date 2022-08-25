package com.leoni.sapbooking.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoni.sapbooking.model.SAPBooking;
import com.leoni.sapbooking.model.SAPHeureCompensations;


public interface SAPHeureCompensationsRepository extends JpaRepository< SAPHeureCompensations, Integer> {
	List<SAPHeureCompensations> findByMatriculeRH(String mat);
	List<SAPHeureCompensations> findByMatriculeRHAndDateBetween(String mat ,Date stardate , Date enddate);

}
