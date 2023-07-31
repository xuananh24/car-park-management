package com.example.car_park_management.controller;

import com.example.car_park_management.common.constant.DefaultValue;
import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.model.request.BookingOfficeInfoRequest;
import com.example.car_park_management.model.response.BookingOfficeInfoResponse;
import com.example.car_park_management.service.BookingOfficeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingOfficeController {
    private final BookingOfficeService bookingOfficeService;

    public BookingOfficeController(BookingOfficeService bookingOfficeService) {
        this.bookingOfficeService = bookingOfficeService;
    }

    @GetMapping(PathConstant.API_BOOKING_OFFICE_SHOW_URL)
    public List<BookingOfficeInfoResponse> show(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "pageSize") int pageSize) {
        return bookingOfficeService.show(
                Optional.ofNullable(page).orElse(DefaultValue.DEFAULT_PAGE),
                Optional.ofNullable(pageSize).orElse(DefaultValue.DEFAULT_PAGE_SIZE)
        );
    }

    @PostMapping(PathConstant.API_BOOKING_OFFICE_CREATION_URL)
    public void create(@RequestBody @Valid BookingOfficeInfoRequest bookingOfficeInfoRequest) {
        bookingOfficeService.create(bookingOfficeInfoRequest);
    }
}
