package com.example.car_park_management.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingLotInfoResponse {
    private Long id;
    private String parkName;
    private String parkPlace;
    private Long area;
    private Long price;
    private String status;
}
