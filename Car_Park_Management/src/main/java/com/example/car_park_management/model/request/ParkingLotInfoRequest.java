package com.example.car_park_management.model.request;

import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ParkingLotInfoRequest {
    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String parkName;

    @NotBlank(message = Message.BLANK_INPUT)
    private String parkPlace;

    @Positive
    private Long area;

    @Positive
    private Long price;
}
