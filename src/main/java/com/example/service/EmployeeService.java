package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.repository.EmployeeRepository;

@service
public class EmployeeService {
	public final EmployeeRepository emplyeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}
