package com.example.car_park_management.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class EmployeeInfoResponse {
    private Long id;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String department;

}
