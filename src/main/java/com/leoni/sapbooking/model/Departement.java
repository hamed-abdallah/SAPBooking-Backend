package com.leoni.sapbooking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDep")
	public Integer idDep;
	@Column(name = "departnom")
	private String departnom;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "idDep")
	private List<Users> user;

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(Integer idDep, String departnom, List<Users> user) {
		super();
		this.idDep = idDep;
		this.departnom = departnom;
		this.user = user;
	}

	public Integer getIdDep() {
		return idDep;
	}

	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
	}

	public String getDepartnom() {
		return departnom;
	}

	public void setDepartnom(String departnom) {
		this.departnom = departnom;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	
}
