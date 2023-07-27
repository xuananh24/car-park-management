package com.example.car_park_management.model.request;

import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

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

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^[1-9]\\d*$", message = Message.INVALID_INPUT)
    private int maximumOnlineTicketNumber;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$", message = Message.INVALID_INPUT)
    private String departureDate;
}
