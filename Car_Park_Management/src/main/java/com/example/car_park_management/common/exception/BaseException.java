package com.example.car_park_management.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {
    protected final HttpStatus httpStatus;

    public BaseException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public BaseException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, null);
    }

    public BaseException(HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
    }
}
