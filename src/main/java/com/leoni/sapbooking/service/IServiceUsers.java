package com.leoni.sapbooking.service;

import java.util.List;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.Users;

public interface IServiceUsers {

	public Users ajouterUsers(Users users);
	public Users mettreAjourUsers(Users users);
	public Users getUserById(int id);
	public String getUserNomById(int id);
	public void deleteUsers(int id);
	public Users fetchUserByEmailAndPassword (String email ,String password);
	public List<Users> getAllUsers();
	public Departement ajouterService (Departement services);
	public Departement mettreAjourDepartById(Departement services,int id );
	public void deleteServices(int id);
	public Departement getServicesById(int id);
	public List<Departement> getAllDepartement();
	public Departement mADepartById(Departement depart);
	public void deleteDepart(int id);
	public List<Users>	getselondepart(Departement depart);
}
