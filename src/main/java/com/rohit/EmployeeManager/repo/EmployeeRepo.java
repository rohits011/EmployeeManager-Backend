package com.rohit.EmployeeManager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.EmployeeManager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Optional<Employee> findEmployeeById(Long id);

//	Object deleteEmployeeById = null;

}
