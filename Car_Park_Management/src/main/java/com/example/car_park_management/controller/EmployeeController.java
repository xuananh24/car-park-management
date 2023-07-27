package com.example.car_park_management.controller;

import com.example.car_park_management.common.constant.DefaultValue;
import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.model.request.EmployeeInfoRequest;
import com.example.car_park_management.model.response.EmployeeInfoResponse;
import com.example.car_park_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(PathConstant.API_EMPLOYEE_SHOW_URL)
    public List<EmployeeInfoResponse> show(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "pageSize") int pageSize) {
        return employeeService.show(
                Optional.ofNullable(page).orElse(DefaultValue.DEFAULT_PAGE),
                Optional.ofNullable(pageSize).orElse(DefaultValue.DEFAULT_PAGE_SIZE)
        );
    }

    @PostMapping(PathConstant.API_EMPLOYEE_CREATION_URL)
    public void create(@RequestParam @Valid EmployeeInfoRequest employeeInfoRequest) {
        employeeService.create(employeeInfoRequest);
    }
}
