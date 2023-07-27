package com.example.car_park_management.controller;

import com.example.car_park_management.common.constant.DefaultValue;
import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.model.request.ParkingLotInfoRequest;
import com.example.car_park_management.model.response.ParkingLotInfoResponse;
import com.example.car_park_management.service.ParkingLotService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping(PathConstant.API_PARKING_LOT_SHOW_URL)
    public List<ParkingLotInfoResponse> show(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "pageSize") int pageSize) {
        return parkingLotService.show(
                Optional.ofNullable(page).orElse(DefaultValue.DEFAULT_PAGE),
                Optional.ofNullable(pageSize).orElse(DefaultValue.DEFAULT_PAGE_SIZE)
        );
    }

    @PostMapping(PathConstant.API_PARKING_LOT_CREATION_URL)
    public void create(@RequestParam @Valid ParkingLotInfoRequest parkingLotInfoRequest) {
        parkingLotService.create(parkingLotInfoRequest);
    }
}
