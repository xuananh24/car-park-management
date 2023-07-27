package com.example.car_park_management.service.impl;

import com.example.car_park_management.model.mapper.EmployeeMapper;
import com.example.car_park_management.model.request.EmployeeInfoRequest;
import com.example.car_park_management.model.response.EmployeeInfoResponse;
import com.example.car_park_management.repository.EmployeeRepository;
import com.example.car_park_management.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(EmployeeInfoRequest employeeInfoRequest) {
        employeeRepository.save(EmployeeMapper.toEntity(employeeInfoRequest));
    }

    @Override
    public List<EmployeeInfoResponse> show(int page, int pageSize) {
        return employeeRepository.findAll(PageRequest.of(page, pageSize)).stream().map(EmployeeMapper::toDTO).toList();
    }

    public String test() {
        throw new RuntimeException("test");
    }
}
