package com.example.car_park_management.model.request;

import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Time;

@Data
public class TicketInfoRequest {
    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String customerName;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = Message.INVALID_INPUT)
    private String bookingTime;

    @Positive
    private Long tripId;

    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String licensePlate;
}
