package com.example.car_park_management.common.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedRequestException extends BaseException {
    public UnauthorizedRequestException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedRequestException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }

    public UnauthorizedRequestException(String message, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, message, cause);
    }
}
