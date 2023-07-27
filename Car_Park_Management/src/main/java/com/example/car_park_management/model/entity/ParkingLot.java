package com.example.car_park_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ParkingLot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long parkId;

    @Column
    private Long parkArea;

    @Column(length = 50)
    private String parkName;

    @Column(length = 11)
    private String parkPlace;

    @Column(columnDefinition = "BIGINT(20)")
    private Long parkPrice;

    @Column(length = 50)
    private String parkStatus;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();
}
