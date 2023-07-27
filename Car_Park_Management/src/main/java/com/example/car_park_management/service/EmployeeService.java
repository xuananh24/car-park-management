package com.example.car_park_management.service;

import com.example.car_park_management.model.request.EmployeeInfoRequest;
import com.example.car_park_management.model.response.EmployeeInfoResponse;

import java.util.List;

public interface EmployeeService {
    void create(EmployeeInfoRequest employeeInfoRequest);
    List<EmployeeInfoResponse> show(int page, int pageSize);
}
