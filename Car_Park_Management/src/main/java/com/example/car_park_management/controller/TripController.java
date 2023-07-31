package com.example.car_park_management.controller;

import com.example.car_park_management.common.constant.DefaultValue;
import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.model.request.TripInfoRequest;
import com.example.car_park_management.model.response.TripInfoResponse;
import com.example.car_park_management.service.TripService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(PathConstant.API_TRIP_SHOW_URL)
    public List<TripInfoResponse> show(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "pageSize") int pageSize) {
        return tripService.show(
                Optional.ofNullable(page).orElse(DefaultValue.DEFAULT_PAGE),
                Optional.ofNullable(pageSize).orElse(DefaultValue.DEFAULT_PAGE_SIZE)
        );
    }

    @PostMapping(PathConstant.API_TRIP_CREATION_URL)
    public void create(@RequestBody @Valid TripInfoRequest tripInfoRequest) {
        tripService.create(tripInfoRequest);
    }
}
