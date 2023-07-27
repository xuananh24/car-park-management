package com.example.car_park_management.service.impl;

import com.example.car_park_management.model.mapper.ParkingLotMapper;
import com.example.car_park_management.model.request.ParkingLotInfoRequest;
import com.example.car_park_management.model.response.ParkingLotInfoResponse;
import com.example.car_park_management.repository.ParkingLotRepository;
import com.example.car_park_management.service.ParkingLotService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public List<ParkingLotInfoResponse> show(int page, int pageSize) {
        return parkingLotRepository.findAll(PageRequest.of(page, pageSize)).stream().map(ParkingLotMapper::toDTO).toList();
    }

    @Override
    public void create(ParkingLotInfoRequest parkingLotInfoRequest) {
        parkingLotRepository.save(ParkingLotMapper.toEntity(parkingLotInfoRequest));
    }
}
