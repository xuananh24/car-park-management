package com.example.car_park_management.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookingOfficeInfoResponse {
    private Long id;
    private String bookingOfficeName;
    private String tripDestination;
}
