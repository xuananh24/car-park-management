package com.example.car_park_management.service;

import com.example.car_park_management.model.request.TicketInfoRequest;
import com.example.car_park_management.model.response.TicketInfoResponse;

import java.util.List;

public interface TicketService {
    List<TicketInfoResponse> show(int page, int pageSize);
    void create(TicketInfoRequest ticketInfoRequest);
    void remove(Long ticketId);
}
