package com.leoni.sapbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leoni.sapbooking.model.Departement;

@Repository
public interface DepartementRepository extends JpaRepository < Departement, Integer> {

}
