package com.leoni.sapbooking.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPBooking;
import com.leoni.sapbooking.model.SAPHeurePresence;
import com.leoni.sapbooking.model.Users;


public interface SAPBookingRepository extends JpaRepository< SAPBooking, Integer> {
	List<SAPBooking> findByPersNum(String persnum);
	List<SAPBooking> findByPersNumAndDateBetween(String mat ,Date stardate , Date enddate);
	List<SAPBooking> findByTeam(String team);
}
