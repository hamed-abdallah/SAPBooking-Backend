package com.leoni.sapbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leoni.sapbooking.model.Departement;
import com.leoni.sapbooking.model.Users;

@Repository
public interface UsersRepository extends JpaRepository< Users, Integer> {
	public Users findByEmail (String email);
	public Users findByEmailAndPassword (String email,String password);
	public Users findByNomAndProfile (String nom,String profile);
	 List<Users> findByIdDep(Departement depart);
}
