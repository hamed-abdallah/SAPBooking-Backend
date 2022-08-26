package com.leoni.sapbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SAPHeureCompensations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "matriculeRH")
	private String matriculeRH;
	@Column(name = "date")
	private Date date;
	@Column(name = "timeTypeText")
	private String timeTypeText;
	@Column(name = "number")
	private float number;
	@Column(name = "costCtr")
	private String costCtr;
	
	public static String[] fields(){
		
		return new String[] {"matriculeRH","name","date","number","TimeTypeText","costCent"};	
	}
	public SAPHeureCompensations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SAPHeureCompensations(Integer id, String name, String matriculeRH, Date date, String timeTypeText,
			float number, String costCtr) {
		super();
		this.id = id;
		this.name = name;
		this.matriculeRH = matriculeRH;
		this.date = date;
		this.timeTypeText = timeTypeText;
		this.number = number;
		this.costCtr = costCtr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMatriculeRH() {
		return matriculeRH;
	}
	public void setMatriculeRH(String matriculeRH) {
		this.matriculeRH = matriculeRH;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTimeTypeText() {
		return timeTypeText;
	}
	public void setTimeTypeText(String timeTypeText) {
		this.timeTypeText = timeTypeText;
	}
	public float getNumber() {
		return number;
	}
	public void setNumber(float number) {
		this.number = number;
	}
	public String getCostCtr() {
		return costCtr;
	}
	public void setCostCtr(String costCtr) {
		this.costCtr = costCtr;
	}

}
