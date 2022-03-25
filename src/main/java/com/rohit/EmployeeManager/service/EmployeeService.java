package com.rohit.EmployeeManager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.EmployeeManager.exception.UserNotFoundException;
import com.rohit.EmployeeManager.model.Employee;
import com.rohit.EmployeeManager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
//	@Autowired
//	public EmployeeService(EmployeeRepo employeeRepo) {
//		this.employeeRepo=employeeRepo;
//	}
	
	public Employee addEmployee(Employee e) {
		e.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(e);
		
	}
	
	public List<Employee> findAllEmployee(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee e) {
		return employeeRepo.save(e);
	}
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	
}
