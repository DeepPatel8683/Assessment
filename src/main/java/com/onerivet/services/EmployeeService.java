package com.onerivet.services;

import java.util.List;

import com.onerivet.models.entity.Employee;
import com.onerivet.models.payload.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto employeeToemployeeDto(Employee employee);
	
	public Employee employeeDtoToemplpyee(EmployeeDto employeeDto);
	
	public String addEmployee(EmployeeDto employeeDto);
	
	public List<EmployeeDto> getAllEmployees();
	
	public EmployeeDto getEmployeeById(int id) throws Exception;
	
	public String updateEmpById(int id,EmployeeDto employeeDto) throws Exception;
	
	public String deleteById(int id) throws Exception;
	
	
	

}
