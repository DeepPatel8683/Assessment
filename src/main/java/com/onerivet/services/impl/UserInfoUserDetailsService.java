package com.onerivet.services.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onerivet.models.entity.Employee;
import com.onerivet.repository.EmployeeRepo;


@Service
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> user = employeeRepo.findByEmail(email);
        return user.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
    }
}