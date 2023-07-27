package com.example.car_park_management.service;

import com.example.car_park_management.model.request.CarInfoRequest;
import com.example.car_park_management.model.response.CarInfoResponse;

import java.util.List;

public interface CarService {
    List<CarInfoResponse> show(int page, int pageSize);
    void create(CarInfoRequest carInfoRequest);
}
