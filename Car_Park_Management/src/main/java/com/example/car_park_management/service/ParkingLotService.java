package com.example.car_park_management.service;

import com.example.car_park_management.model.request.ParkingLotInfoRequest;
import com.example.car_park_management.model.response.ParkingLotInfoResponse;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLotInfoResponse> show(int page, int pageSize);
    void create(ParkingLotInfoRequest parkingLotInfoRequest);
}
