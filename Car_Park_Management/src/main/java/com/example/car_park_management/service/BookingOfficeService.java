package com.example.car_park_management.service;

import com.example.car_park_management.model.request.BookingOfficeInfoRequest;
import com.example.car_park_management.model.response.BookingOfficeInfoResponse;

import java.util.List;

public interface BookingOfficeService {
    List<BookingOfficeInfoResponse> show(int page, int pageSize);

    void create(BookingOfficeInfoRequest bookingOffice);
}
