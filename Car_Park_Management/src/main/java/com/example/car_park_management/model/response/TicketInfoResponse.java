package com.example.car_park_management.model.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Time;

@Data
@Builder
public class TicketInfoResponse {
    private Long id;
    private String tripDestination;
    private String licensePlate;
    private String customerName;
    private Time bookingTime;
}
