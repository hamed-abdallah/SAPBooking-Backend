package com.leoni.sapbooking.service;

import java.sql.Date;
import java.util.List;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPBooking;

public interface IServiceSAPBooking {
	
	public List<SAPBooking> getallbooking();
	public List<SAPBooking>	getselonmat(String mat);
	public List<SAPBooking> getbookselondate (String mat,Date stardate ,Date enddate);
	public List<SAPBooking>	getselonteam(String team);
}
