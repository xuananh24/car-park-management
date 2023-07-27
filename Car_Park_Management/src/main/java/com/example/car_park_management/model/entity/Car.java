package com.example.car_park_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @Column(length = 50)
    private String licensePlate;

    @Column(length = 11)
    private String carColor;

    @Column(length = 50)
    private String carType;

    @Column(length = 50)
    private String company;

    @ManyToOne
    @JoinColumn(name = "parkId")
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "licensePlate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();
}
