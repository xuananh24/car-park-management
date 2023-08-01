package com.example.car_park_management.model.mapper;

import com.example.car_park_management.model.request.ParkingLotInfoRequest;
import com.example.car_park_management.model.response.ParkingLotInfoResponse;
import com.example.car_park_management.model.entity.ParkingLot;

public class ParkingLotMapper {
    public static ParkingLot toEntity(ParkingLotInfoRequest parkingLotInfoRequest) {
        return ParkingLot.builder()
                .parkArea(parkingLotInfoRequest.getArea())
                .parkPrice(parkingLotInfoRequest.getPrice())
                .parkName(parkingLotInfoRequest.getParkName())
                .parkArea(parkingLotInfoRequest.getArea())
                .parkPlace(parkingLotInfoRequest.getParkName())
                .build();
    }

    public static ParkingLotInfoResponse toDTO(ParkingLot parkingLot) {
        return ParkingLotInfoResponse.builder()
                .id(parkingLot.getParkId())
                .parkName(parkingLot.getParkName())
                .parkPlace(parkingLot.getParkPlace())
                .area(parkingLot.getParkArea())
                .price(parkingLot.getParkPrice())
                .status(parkingLot.getParkStatus())
                .build();
    }
}
