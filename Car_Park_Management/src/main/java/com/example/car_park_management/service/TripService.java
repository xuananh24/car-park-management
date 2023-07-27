package com.example.car_park_management.service;

import com.example.car_park_management.model.request.TripInfoRequest;
import com.example.car_park_management.model.response.TripInfoResponse;

import java.util.List;

public interface TripService {
    List<TripInfoResponse> show(int page, int pageSize);
    void create(TripInfoRequest tripInfoRequest);
}
