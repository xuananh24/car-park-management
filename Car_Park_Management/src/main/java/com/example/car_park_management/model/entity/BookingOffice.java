package com.example.car_park_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "BookingOffice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long officeId;

    @Column
    @Temporal(TemporalType.DATE)
    private Date endContractDeadline;

    @Column(length = 50)
    private String officeName;

    @Column(length = 11)
    private String officePhone;

    @Column(length = 50)
    private String officePlace;

    @Column(columnDefinition = "BIGINT(20)")
    private Long officePrice;

    @Column
    @Temporal(TemporalType.DATE)
    private Date startContractDeadline;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

}
