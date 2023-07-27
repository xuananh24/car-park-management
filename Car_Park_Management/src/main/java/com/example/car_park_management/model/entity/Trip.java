package com.example.car_park_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Trip")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long tripId;

    @Column(columnDefinition = "INT(11)")
    private int bookedTicketNumber;

    @Column(length = 11)
    private String carType;

    @Column
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column
    @Temporal(TemporalType.TIME)
    private Time departureTime;

    @Column(length = 50)
    private String destination;

    @Column(length = 11)
    private String driver;

    @Column(columnDefinition = "INT(11)")
    private int maximumOnlineTicketNumber;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingOffice> bookingOffices = new ArrayList<>();
}
