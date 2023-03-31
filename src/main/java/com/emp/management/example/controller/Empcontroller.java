package com.emp.management.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.management.example.entity.Employee;
import com.emp.management.example.service.Empservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class Empcontroller {

	@Autowired
	private Empservice service;
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp = service.getallemp();
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addempForm() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Employee e,HttpSession session) {
		service.addemp(e);
		session.setAttribute("msg","Employee added successfully");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m ) {
		Employee e= service.getEmpByid(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session){
		service.addemp(e);
		session.setAttribute("msg", "Employee  "+e.getId()+" updated successfully");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delEmp(@PathVariable int id,HttpSession session) {
		service.delEmp(id);
		session.setAttribute("msg", " Employee "+id+" deleted successfully");
		return "redirect:/";
	}
	
	
	
}
