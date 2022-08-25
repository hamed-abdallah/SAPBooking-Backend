package com.leoni.sapbooking.service;

import java.sql.Date;
import java.util.List;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.SAPHeurePresence;

public interface IServiceSAPHeurePresence {
	public List<SAPHeurePresence>	getheureselonmat(String mat);
	public List<SAPHeurePresence> getallheurepresence();
	public List<SAPHeurePresence> getselondate (String mat, Date stardate ,Date enddate);
}
