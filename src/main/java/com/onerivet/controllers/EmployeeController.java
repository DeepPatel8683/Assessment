package com.onerivet.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onerivet.models.payload.EmployeeDto;
import com.onerivet.models.responce.GenericResponse;
import com.onerivet.services.EmployeeService;
import com.onerivet.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/employee")
	public String addEmployeeDetails( @RequestBody EmployeeDto employeeDto) {
				
		return employeeService.addEmployee(employeeDto);
				
	}
	
	@GetMapping("/employees")
	public GenericResponse<List<EmployeeDto>>allEmployeeDetails(){
		
		GenericResponse<List<EmployeeDto>> genericResponse =new GenericResponse<>(this.employeeService.getAllEmployees(), null);
		
		return genericResponse;
			
		
	}
	
	@GetMapping("/{id}")
	public  GenericResponse<EmployeeDto>  getEmployeeById(@PathVariable int id) throws Exception {
		GenericResponse<EmployeeDto> genericResponse =new GenericResponse<>(this.employeeService.getEmployeeById(id), null);
		return genericResponse;
			
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public GenericResponse<String> deleteById(@PathVariable int id)throws Exception {
		
		GenericResponse<String> genericResponse =new GenericResponse<>(this.employeeService.deleteById(id), null);
		
		return genericResponse;
		
		
	}
	
	@PutMapping("/update/{id}")
	public GenericResponse<String> updateById(@PathVariable int id, @RequestBody EmployeeDto employeeDto) throws Exception {
		
		
        GenericResponse<String> genericResponse =new GenericResponse<>(this.employeeService.updateEmpById(id, employeeDto), null);
		
		return genericResponse;	
		
		
	}
	
	
	@PostMapping("/token")
    public String generateToken(@RequestBody EmployeeDto employeeDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(employeeDto.getEmail(), employeeDto.getPassword()));
        System.out.println("hehe");
        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(employeeDto.getEmail());
        } else {
            throw new UsernameNotFoundException("User not found!!");
        }
    }
	
	
}
	
	
		
		
		
