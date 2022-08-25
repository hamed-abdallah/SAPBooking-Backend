package com.leoni.sapbooking.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.Users;
import com.leoni.sapbooking.repository.DepartementRepository;
import com.leoni.sapbooking.repository.UsersRepository;



@Service
public class UsersService implements IServiceUsers {
	
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	DepartementRepository departementRepository;
	
	
	public Users ajouterUsers (Users users) {
		usersRepository.save(users);
		return users;
	}

	
	public Users mettreAjourUsers(Users users ) {
		
		
		return usersRepository.save(users);

		
	}
		
	public Users getUserById(int id) {
		return usersRepository.findById(id).get();
	}
	public void deleteUsers(int id) {
		Users user = usersRepository.findById(id).get();
		usersRepository.delete(user);
	}
	public List<Users> getAllUsers() {
		return (List<Users>) usersRepository.findAll();
}
	

	
	public String getUserNomById(int id) {
		Users user = usersRepository.findById(id).get();
		return user.getNom();
	}

public Users fetchUserByEmailAndPassword (String email ,String password) {
	
	return usersRepository.findByEmailAndPassword(email, password);
	
}
public Departement ajouterService (Departement services) {
	departementRepository.save(services);
	return services;
}

public List<Departement> getAllDepartement() {
	
	return (List<Departement>) departementRepository.findAll();
}
public Departement getServicesById(int id) {
	return departementRepository.findById(id).get();
}
public void deleteServices(int id) {
	Departement user = departementRepository.findById(id).get();
	departementRepository.delete(user);
}
public Departement mADepartById(Departement depart ) {

	return departementRepository.save(depart);

	
}
public void deleteDepart(int id) {
	Departement depart = departementRepository.findById(id).get();
	departementRepository.delete(depart);
}
public List<Users>	getselondepart(Departement depart){
	List<Users> user =usersRepository.findByIdDep(depart);
	return user ;
}
public Departement mettreAjourDepartById(Departement services,int id ) {
	List<Users> user= usersRepository.findByIdDep(services);
	Departement service = departementRepository.findById(id).get();
	service.idDep=id;
	service.setUser(user);
	return departementRepository.save(service);

}
}
