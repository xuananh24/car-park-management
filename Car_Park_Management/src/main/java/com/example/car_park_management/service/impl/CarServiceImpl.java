package com.example.car_park_management.service.impl;

import com.example.car_park_management.common.constant.Message;
import com.example.car_park_management.common.exception.NotFoundException;
import com.example.car_park_management.model.mapper.CarMapper;
import com.example.car_park_management.model.request.CarInfoRequest;
import com.example.car_park_management.model.response.CarInfoResponse;
import com.example.car_park_management.model.entity.Car;
import com.example.car_park_management.model.entity.ParkingLot;
import com.example.car_park_management.repository.CarRepository;
import com.example.car_park_management.repository.ParkingLotRepository;
import com.example.car_park_management.service.CarService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ParkingLotRepository parkingLotRepository;

    public CarServiceImpl(CarRepository carRepository, ParkingLotRepository parkingLotRepository) {
        this.carRepository = carRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public List<CarInfoResponse> show(int page, int pageSize) {
        return carRepository.findAll(PageRequest.of(page, pageSize)).stream().map(CarMapper::toDTO).toList();
    }

    @Override
    public void create(CarInfoRequest carInfoRequest) {
        ParkingLot parkingLot = parkingLotRepository.findById(carInfoRequest.getParkingLotId()).orElseThrow(
                () -> new NotFoundException(Message.NOT_FOUND)
        );
        Car car = CarMapper.toEntity(carInfoRequest);
        car.setParkingLot(parkingLot);
        carRepository.save(car);
    }
}
