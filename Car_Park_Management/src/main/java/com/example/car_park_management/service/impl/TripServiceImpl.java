package com.example.car_park_management.service.impl;

import com.example.car_park_management.model.mapper.TripMapper;
import com.example.car_park_management.model.request.TripInfoRequest;
import com.example.car_park_management.model.response.TripInfoResponse;
import com.example.car_park_management.repository.TripRepository;
import com.example.car_park_management.service.TripService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<TripInfoResponse> show(int page, int pageSize) {
        return tripRepository.findAll(PageRequest.of(page, pageSize)).stream().map(TripMapper::toDTO).toList();
    }

    @Override
    public void create(TripInfoRequest tripInfoRequest) {
        tripRepository.save(TripMapper.toEntity(tripInfoRequest));
    }
}
