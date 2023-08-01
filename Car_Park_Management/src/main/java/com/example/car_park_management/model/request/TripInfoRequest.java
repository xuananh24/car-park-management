package com.example.car_park_management.model.request;

import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TripInfoRequest {
    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String destination;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = Message.INVALID_INPUT)
    private String departureTime;

    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String driver;

    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String carType;

    @Positive
    private int maximumOnlineTicketNumber;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\\\d|3[0-1])$", message = Message.INVALID_INPUT)
    private String departureDate;
}
