package com.example.car_park_management.service.impl;

import com.example.car_park_management.common.constant.Message;
import com.example.car_park_management.common.exception.NotFoundException;
import com.example.car_park_management.model.mapper.BookingOfficeMapper;
import com.example.car_park_management.model.request.BookingOfficeInfoRequest;
import com.example.car_park_management.model.response.BookingOfficeInfoResponse;
import com.example.car_park_management.model.entity.BookingOffice;
import com.example.car_park_management.model.entity.Trip;
import com.example.car_park_management.repository.BookingOfficeRepository;
import com.example.car_park_management.repository.TripRepository;
import com.example.car_park_management.service.BookingOfficeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingOfficeServiceImpl implements BookingOfficeService {

    private final BookingOfficeRepository bookingOfficeRepository;
    private final TripRepository tripRepository;

    public BookingOfficeServiceImpl(BookingOfficeRepository bookingOfficeRepository, TripRepository tripRepository) {
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public List<BookingOfficeInfoResponse> show(int page, int pageSize) {
        return bookingOfficeRepository.findAll(PageRequest.of(page, pageSize)).stream().map(BookingOfficeMapper::toDTO).toList();
    }

    @Override
    public void create(BookingOfficeInfoRequest bookingOfficeInfoRequest) {
        Trip trip = tripRepository.findById(bookingOfficeInfoRequest.getTripId()).orElseThrow(
                () -> new NotFoundException(Message.NOT_FOUND)
        );
        BookingOffice bookingOffice = BookingOfficeMapper.toEntity(bookingOfficeInfoRequest);
        bookingOffice.setTrip(trip);
        bookingOfficeRepository.save(bookingOffice);
    }
}
