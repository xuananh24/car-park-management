package com.example.car_park_management.security;

import com.example.car_park_management.common.constant.Message;
import com.example.car_park_management.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

public class UserInfoService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public UserInfoService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findEmployeeByAccount(username).map(UserInfo::new).orElseThrow(() -> new UsernameNotFoundException(Message.NOT_FOUND));
    }
}
