package com.onerivet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.models.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	 Optional<Employee> findByEmail(String email); 

}
