package com.example.car_park_management.model.mapper;

import com.example.car_park_management.model.request.EmployeeInfoRequest;
import com.example.car_park_management.model.response.EmployeeInfoResponse;
import com.example.car_park_management.model.entity.Employee;
import com.example.car_park_management.utils.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeInfoRequest employeeInfoRequest) {
        return Employee.builder()
                .employeeName(employeeInfoRequest.getName())
                .employeePhone(employeeInfoRequest.getPhoneNumber())
                .employeeBirthDate(Converter.stringToDate(employeeInfoRequest.getDateOfBirth()))
                .sex(employeeInfoRequest.getSex())
                .employeeAddress(employeeInfoRequest.getAddress())
                .employeeEmail(employeeInfoRequest.getEmail())
                .account(employeeInfoRequest.getAccount())
                .password(employeeInfoRequest.getPassword())
                .department(employeeInfoRequest.getDepartment())
                .build();
    }

    public static EmployeeInfoResponse toDTO(Employee employee) {
        return EmployeeInfoResponse.builder()
                .id(employee.getEmployeeId())
                .name(employee.getEmployeeName())
                .phoneNumber(employee.getEmployeePhone())
                .dateOfBirth(employee.getEmployeeBirthDate())
                .address(employee.getEmployeeAddress())
                .department(employee.getDepartment())
                .build();
    }
}
