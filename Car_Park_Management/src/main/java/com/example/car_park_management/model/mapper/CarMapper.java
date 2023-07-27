package com.example.car_park_management.model.mapper;

import com.example.car_park_management.model.request.CarInfoRequest;
import com.example.car_park_management.model.response.CarInfoResponse;
import com.example.car_park_management.model.entity.Car;

public class CarMapper {
    public static Car toEntity(CarInfoRequest carInfoRequest) {
        return Car.builder()
                .licensePlate(carInfoRequest.getLicensePlate())
                .carType(carInfoRequest.getCarType())
                .carColor(carInfoRequest.getCarColor())
                .company(carInfoRequest.getCompany())
                .build();
    }

    public static CarInfoResponse toDTO(Car car) {
        return CarInfoResponse.builder()
                .licensePlate(car.getLicensePlate())
                .carColor(car.getCarColor())
                .carType(car.getCarType())
                .company(car.getCompany())
                .parkName(car.getParkingLot().getParkName())
                .build();
    }
}
