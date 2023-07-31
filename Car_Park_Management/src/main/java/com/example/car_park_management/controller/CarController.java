package com.example.car_park_management.controller;

import com.example.car_park_management.common.constant.DefaultValue;
import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.model.request.CarInfoRequest;
import com.example.car_park_management.model.response.CarInfoResponse;
import com.example.car_park_management.service.CarService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(PathConstant.API_CAR_SHOW_URL)
    public List<CarInfoResponse> show(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "pageSize") int pageSize) {
        return carService.show(
                Optional.ofNullable(page).orElse(DefaultValue.DEFAULT_PAGE),
                Optional.ofNullable(pageSize).orElse(DefaultValue.DEFAULT_PAGE_SIZE)
        );
    }

    @PostMapping(PathConstant.API_CAR_CREATION_URL)
    public void create(@RequestBody @Valid CarInfoRequest carInfoRequest) {
        carService.create(carInfoRequest);
    }
}
