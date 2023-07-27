package com.example.car_park_management.repository;

import com.example.car_park_management.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
