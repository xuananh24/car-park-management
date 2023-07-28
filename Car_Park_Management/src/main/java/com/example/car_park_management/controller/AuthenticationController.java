package com.example.car_park_management.controller;

import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.common.exception.UnauthorizedRequestException;
import com.example.car_park_management.model.entity.Employee;
import com.example.car_park_management.model.request.AuthenticationRequest;
import com.example.car_park_management.model.response.JwtResponse;
import com.example.car_park_management.repository.EmployeeRepository;
import com.example.car_park_management.security.EmployeeDetails;
import com.example.car_park_management.utils.JwtTokenUtils;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthenticationController {
    private final JwtTokenUtils jwtTokenUtils;
    private final EmployeeRepository employeeRepository;

    public AuthenticationController(JwtTokenUtils jwtTokenUtils, EmployeeRepository employeeRepository) {
        this.jwtTokenUtils = jwtTokenUtils;
        this.employeeRepository = employeeRepository;
    }


    @PostMapping(PathConstant.API_AUTHENTICATION_URL)
    public JwtResponse authenticate(
            @RequestBody @NotNull AuthenticationRequest request) {
        String username = request.getUsername();
        Employee employee = employeeRepository.findEmployeeByAccount(username).get();
        Optional<EmployeeDetails> employeeDetails = Optional.ofNullable(new EmployeeDetails(employee));
        String token = this.jwtTokenUtils.createToken(employeeDetails.get());
        String a = token;
        return JwtResponse.builder().token(token).build();
    }

}
