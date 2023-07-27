package com.example.car_park_management.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TripInfoResponse {
    private Long id;
    private String destination;
    private String driver;
    private String carType;
    private int bookedTicketNumber;
}
