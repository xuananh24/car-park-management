package com.example.car_park_management.model.request;

import com.example.car_park_management.common.constant.Message;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeInfoRequest {
    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String name;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^[0-9]{10}$", message = Message.INVALID_INPUT)
    private String phoneNumber;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\\\d|3[0-1])$", message = Message.INVALID_INPUT)
    private String dateOfBirth;

    @NotBlank(message = Message.BLANK_INPUT)
    @Pattern(regexp = "^[mMfF]$", message = Message.INVALID_INPUT)
    private String sex;

    @Size(max = 50, message = Message.INVALID_INPUT)
    private String address;

    @Email(message = Message.INVALID_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String email;

    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String account;

    @NotBlank(message = Message.BLANK_INPUT)
    @Size(max = 50, message = Message.INVALID_INPUT)
    private String password;

    @NotBlank(message = Message.BLANK_INPUT)
    private String department;

}
