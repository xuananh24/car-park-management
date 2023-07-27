package com.example.car_park_management.model.mapper;

import com.example.car_park_management.model.request.TripInfoRequest;
import com.example.car_park_management.model.response.TripInfoResponse;
import com.example.car_park_management.model.entity.Trip;
import com.example.car_park_management.utils.Converter;

public class TripMapper {
    public static Trip toEntity(TripInfoRequest tripInfoRequest) {
        return Trip.builder()
                .carType(tripInfoRequest.getCarType())
                .destination(tripInfoRequest.getDestination())
                .departureTime(Converter.stringToTime(tripInfoRequest.getDepartureTime()))
                .departureDate(Converter.stringToDate(tripInfoRequest.getDepartureDate()))
                .maximumOnlineTicketNumber(tripInfoRequest.getMaximumOnlineTicketNumber())
                .driver(tripInfoRequest.getDriver())
                .build();
    }

    public static TripInfoResponse toDTO(Trip trip) {
        return TripInfoResponse.builder()
                .id(trip.getTripId())
                .destination(trip.getDestination())
                .driver(trip.getDriver())
                .carType(trip.getCarType())
                .bookedTicketNumber(trip.getBookedTicketNumber())
                .build();
    }
}
