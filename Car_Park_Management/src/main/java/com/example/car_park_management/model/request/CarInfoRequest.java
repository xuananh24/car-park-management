package com.example.car_park_management.model.request;

import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^[1-9]\\d*$", message = Message.INVALID_INPUT)
    private Long parkingLotId;
}
