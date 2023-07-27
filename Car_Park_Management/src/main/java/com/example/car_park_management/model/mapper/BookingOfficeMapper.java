package com.example.car_park_management.model.mapper;

import com.example.car_park_management.model.request.BookingOfficeInfoRequest;
import com.example.car_park_management.model.response.BookingOfficeInfoResponse;
import com.example.car_park_management.model.entity.BookingOffice;
import com.example.car_park_management.utils.Converter;

public class BookingOfficeMapper {
    public static BookingOffice toEntity(BookingOfficeInfoRequest bookingOfficeInfoRequest) {
        return BookingOffice.builder()
                .officeName(bookingOfficeInfoRequest.getBookingOfficeName())
                .officePhone(bookingOfficeInfoRequest.getPhoneNumber())
                .officePlace(bookingOfficeInfoRequest.getPlace())
                .officePrice(bookingOfficeInfoRequest.getPrice())
                .startContractDeadline(Converter.stringToDate(bookingOfficeInfoRequest.getStartContactDeadline()))
                .endContractDeadline(Converter.stringToDate(bookingOfficeInfoRequest.getEndContactDeadline()))
                .build();
    }

    public static BookingOfficeInfoResponse toDTO(BookingOffice bookingOffice) {
        return BookingOfficeInfoResponse.builder()
                .id(bookingOffice.getOfficeId())
                .bookingOfficeName(bookingOffice.getOfficeName())
                .tripDestination(bookingOffice.getTrip().getDestination())
                .build();
    }
}
