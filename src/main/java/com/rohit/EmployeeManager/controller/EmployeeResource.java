package com.rohit.EmployeeManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.EmployeeManager.model.Employee;
import com.rohit.EmployeeManager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    
	@Autowired
	private  EmployeeService employeeService;

//	@Autowired
//	public EmployeeResource(EmployeeService employeeService) {
////		super();
//		this.employeeService = employeeService;
//	}
	

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		List<Employee> employees = employeeService.findAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);

	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){

		Employee e=employeeService.findEmployeeById(id);
		return new ResponseEntity<>(e,HttpStatus.OK);}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e){
		Employee employee=employeeService.addEmployee(e);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);}
		
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e){
		Employee employee=employeeService.updateEmployee(e);
		return new ResponseEntity<>(employee,HttpStatus.OK);}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.CREATED);}
		
}
