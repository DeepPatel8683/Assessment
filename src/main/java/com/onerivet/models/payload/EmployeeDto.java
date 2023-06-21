package com.onerivet.models.payload;

import com.onerivet.models.entity.Address;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
     private int id;
	
     private String firstName;
     
     private String lastName;
      
      private String email;
      
      private String password;
          
      private Address address;



}
