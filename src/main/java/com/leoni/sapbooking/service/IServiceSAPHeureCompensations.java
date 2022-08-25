package com.leoni.sapbooking.service;

import java.sql.Date;
import java.util.List;

import com.leoni.sapbooking.model.SAPHeureCompensations;

public interface IServiceSAPHeureCompensations {
	public List<SAPHeureCompensations> getallheurecompensations();
	public List<SAPHeureCompensations>	getcompselonmat(String mat);
	public List<SAPHeureCompensations> getcompselondate (String mat ,Date stardate ,Date enddate);
}
