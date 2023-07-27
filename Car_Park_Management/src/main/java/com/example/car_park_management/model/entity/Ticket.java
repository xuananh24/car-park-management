package com.example.car_park_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long ticketId;

    @Column
    @Temporal(TemporalType.TIME)
    private Time bookingTime;

    @Column(length = 11)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "licensePlate")
    private Car licensePlate;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;
}
