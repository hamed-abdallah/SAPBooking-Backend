package com.leoni.sapbooking.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "email")
	private String email;
	@Column(name = "profile")
	private String profile ;
	
	@Column(name = "matriculeRH")
	private String matriculeRH ;
	@Column(name = "tel")
	private String tel ;
	@Column(name = "password")
	private String password ;
	@Column(name = "SAPid")
	private String SAPid ;
	
	
	
	@ManyToOne
    @JoinColumn(name = "idDep", insertable = true, updatable = true)
	public Departement idDep;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Integer id, String nom, String prenom, String email, String profile, String matriculeRH, String tel,
			String password, String sAPid, Departement idDep) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.profile = profile;
		this.matriculeRH = matriculeRH;
		this.tel = tel;
		this.password = password;
		SAPid = sAPid;
		this.idDep = idDep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getMatriculeRH() {
		return matriculeRH;
	}

	public void setMatriculeRH(String matriculeRH) {
		this.matriculeRH = matriculeRH;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSAPid() {
		return SAPid;
	}

	public void setSAPid(String sAPid) {
		SAPid = sAPid;
	}

	public Departement getIdDep() {
		return idDep;
	}

	public void setIdDep(Departement idDep) {
		this.idDep = idDep;
	}

	

}