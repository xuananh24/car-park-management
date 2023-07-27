package com.example.car_park_management.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarInfoResponse {
    private String licensePlate;
    private String carType;
    private String carColor;
    private String company;
    private String parkName;
}
