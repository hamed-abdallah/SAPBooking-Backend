package com.leoni.sapbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SAPHeurePresence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "matriculeRH")
	private String matriculeRH;
	@Column(name = "name")
	private String name;
	@Column(name = "date")
	private Date date;
	@Column(name = "numb")
	private float numb;
	@Column(name = "costCtr")
	private int costCtr;
	@Column(name = "costCent")
	private String costCent;
	
	
	public SAPHeurePresence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static String[] fields(){
		
		return new String[] {"matriculeRH","name","date","numb","costCent","costCtr"};	
	}
	public SAPHeurePresence(int id, String matriculeRH, String name, Date date, float numb, String costCent,
			int costCtr) {
		super();
		this.id = id;
		this.matriculeRH = matriculeRH;
		this.name = name;
		this.date = date;
		this.numb = numb;
		this.costCtr = costCtr;
		this.costCent = costCent;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatriculeRH() {
		return matriculeRH;
	}
	public void setMatriculeRH(String matriculeRH) {
		this.matriculeRH = matriculeRH;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getNumb() {
		return numb;
	}
	public void setNumb(float numb) {
		this.numb = numb;
	}
	public int getCostCtr() {
		return costCtr;
	}
	public void setCostCtr(int costCtr) {
		this.costCtr = costCtr;
	}
	public String getCostCent() {
		return costCent;
	}
	public void setCostCent(String costCent) {
		this.costCent = costCent;
	}
	
	
}
