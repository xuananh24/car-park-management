package com.example.car_park_management.service.impl;

import com.example.car_park_management.common.constant.Message;
import com.example.car_park_management.common.exception.NotFoundException;
import com.example.car_park_management.model.mapper.TicketMapper;
import com.example.car_park_management.model.request.TicketInfoRequest;
import com.example.car_park_management.model.response.TicketInfoResponse;
import com.example.car_park_management.model.entity.Car;
import com.example.car_park_management.model.entity.Ticket;
import com.example.car_park_management.model.entity.Trip;
import com.example.car_park_management.repository.CarRepository;
import com.example.car_park_management.repository.TicketRepository;
import com.example.car_park_management.repository.TripRepository;
import com.example.car_park_management.service.TicketService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TripRepository tripRepository;
    protected final CarRepository carRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, TripRepository tripRepository, CarRepository carRepository) {
        this.ticketRepository = ticketRepository;
        this.tripRepository = tripRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<TicketInfoResponse> show(int page, int pageSize) {
        return ticketRepository.findAll(PageRequest.of(page, pageSize)).stream().map(TicketMapper::toDTO).toList();
    }

    @Override
    public void create(TicketInfoRequest ticketInfoRequest) {
        Trip trip = tripRepository.findById(ticketInfoRequest.getTripId()).orElseThrow(
                () -> new NotFoundException(Message.NOT_FOUND)
        );
        Car car = carRepository.findById(ticketInfoRequest.getLicensePlate()).orElseThrow(
                () -> new NotFoundException(Message.NOT_FOUND)
        );
        Ticket ticket = TicketMapper.toEntity(ticketInfoRequest);
        ticket.setTrip(trip);
        ticket.setLicensePlate(car);
        ticketRepository.save(ticket);
    }

    @Override
    public void remove(Long ticketId) {
        tripRepository.deleteById(ticketId);
    }
}
