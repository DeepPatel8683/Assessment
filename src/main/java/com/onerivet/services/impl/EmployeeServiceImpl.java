package com.onerivet.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.exception.ResourceNotFoundException;
import com.onerivet.models.entity.Employee;

import com.onerivet.models.payload.EmployeeDto;
import com.onerivet.repository.EmployeeRepo;
import com.onerivet.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private EmployeeRepo employeerepo;
	

	@Override
	public EmployeeDto employeeToemployeeDto(Employee employee) {
		
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		
		return employeeDto;
	}

	@Override
	public Employee employeeDtoToemplpyee(EmployeeDto employeeDto) {
		
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		
		return employee;
	}

	@Override
	public String addEmployee(EmployeeDto employeeDto) {
		
		
		
		Employee employee =employeeDtoToemplpyee(employeeDto);
				
		employeerepo.save(employee);
		
		return "Employee Added Successfully...";
		
		
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
				
		return employeerepo.findAll().stream().map(allEmp -> modelMapper.map(allEmp, EmployeeDto.class)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployeeById(int id) throws Exception  {
		
		Employee employee =employeerepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found."));
		
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public String updateEmpById(int id, EmployeeDto employeeDto) throws Exception {
		
		
     Employee employee =employeerepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found."));
     
     
 	if (employee != null) {
		Employee save = employeerepo.save(employeeDtoToemplpyee(employeeDto));
		if (save != null) {
			
			
			return "update successfully....";
		}
	}
	return "not update..";
   }
	

	@Override
	public String deleteById(int id) throws Exception{
		
     Employee employee =employeerepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found."));
     
     if(employee!=null) {
    	 
    	this.employeerepo.delete(employee);	 
    	 
     }else {
    	 
    	 return " Employee not found...";
     }
        		
		return "delete successfully...." ;
	}
	
	
	
}
