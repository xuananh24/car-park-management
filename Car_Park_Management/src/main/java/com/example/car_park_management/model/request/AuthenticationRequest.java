package com.example.car_park_management.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AuthenticationRequest {
    @NotNull
    private String username;

    @NotNull
    private String password;
}
