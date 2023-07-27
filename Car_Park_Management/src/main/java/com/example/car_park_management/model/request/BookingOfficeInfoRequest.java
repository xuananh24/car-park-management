package com.example.car_park_management.model.request;


import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class BookingOfficeInfoRequest {
    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String bookingOfficeName;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^[1-9]\\d*$", message = Message.INVALID_INPUT)
    private Long tripId;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^[0-9]{10}$", message = Message.INVALID_INPUT)
    private String phoneNumber;

    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String place;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^[1-9]\\d*$", message = Message.INVALID_INPUT)
    private Long price;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$", message = Message.INVALID_INPUT)
    private String startContactDeadline;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$", message = Message.INVALID_INPUT)
    private String endContactDeadline;
}
