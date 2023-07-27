package com.example.car_park_management.model.mapper;

import com.example.car_park_management.model.request.TicketInfoRequest;
import com.example.car_park_management.model.response.TicketInfoResponse;
import com.example.car_park_management.model.entity.Ticket;
import com.example.car_park_management.utils.Converter;

public class TicketMapper {
    public static Ticket toEntity(TicketInfoRequest ticketInfoRequest) {
        return Ticket.builder()
                .customerName(ticketInfoRequest.getCustomerName())
                .bookingTime(Converter.stringToTime(ticketInfoRequest.getBookingTime()))
                .build();
    }

    public static TicketInfoResponse toDTO(Ticket ticket) {
        return TicketInfoResponse.builder()
                .licensePlate(ticket.getLicensePlate().getLicensePlate())
                .id(ticket.getTicketId())
                .bookingTime(ticket.getBookingTime())
                .customerName(ticket.getCustomerName())
                .tripDestination(ticket.getTrip().getDestination())
                .build();
    }
}
