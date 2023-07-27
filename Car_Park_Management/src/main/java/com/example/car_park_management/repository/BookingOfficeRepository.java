package com.example.car_park_management.repository;

import com.example.car_park_management.model.entity.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {
}
