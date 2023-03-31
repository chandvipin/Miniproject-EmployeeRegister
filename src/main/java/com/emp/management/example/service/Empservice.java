package com.emp.management.example.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.management.example.entity.Employee;
import com.emp.management.example.repository.Emprepository;



@Service
public class Empservice {

	@Autowired
	private Emprepository emprepo;
	
	public void addemp(Employee e) {
		emprepo.save(e);
	}
	
	public List<Employee> getallemp(){
		return emprepo.findAll();
	}
	
	public Employee getEmpByid(int id) {
		Optional<Employee> e =  emprepo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void delEmp(int id) {
		emprepo.deleteById(id);
	}
	
	
	
	
}
