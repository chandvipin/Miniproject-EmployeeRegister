package com.emp.management.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.management.example.entity.Employee;

@Repository
public interface Emprepository extends JpaRepository<Employee, Integer>{

	
	
	
}
