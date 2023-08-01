package com.example.car_park_management.model.request;

import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CarInfoRequest {
    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String licensePlate;

    @Size(max = 50, message = Message.INVALID_INPUT)
    private String carType;

    @Size(max = 50, message = Message.INVALID_INPUT)
    private String carColor;

    @NotBlank(message = Message.BLANK_INPUT)
    private String company;

    @Positive
    private Long parkingLotId;
}
