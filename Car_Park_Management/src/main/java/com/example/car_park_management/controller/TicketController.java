package com.example.car_park_management.controller;

import com.example.car_park_management.common.constant.DefaultValue;
import com.example.car_park_management.common.constant.PathConstant;
import com.example.car_park_management.model.request.TicketInfoRequest;
import com.example.car_park_management.model.response.TicketInfoResponse;
import com.example.car_park_management.service.TicketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(PathConstant.API_TICKET_SHOW_URL)
    public List<TicketInfoResponse> show(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "pageSize") int pageSize) {
        return ticketService.show(
                Optional.ofNullable(page).orElse(DefaultValue.DEFAULT_PAGE),
                Optional.ofNullable(pageSize).orElse(DefaultValue.DEFAULT_PAGE_SIZE)
        );
    }

    @PostMapping(PathConstant.API_TICKET_CREATION_URL)
    public void create(@RequestBody @Valid TicketInfoRequest ticketInfoRequest) {
        ticketService.create(ticketInfoRequest);
    }

    @DeleteMapping(PathConstant.API_TICKET_DELETE_URL)
    public void delete(@PathVariable(name = "ticketId") @NotNull Long ticketId) {
        ticketService.remove(ticketId);
    }
}
