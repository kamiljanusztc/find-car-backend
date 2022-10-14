package com.app.findcarbackend.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CARS")
public class Car {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "CAR_ID", unique = true)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "GEARBOX")
    private String gearbox;

    @Column(name = "FUEL_TYPE")
    private String fuelType;

    @Column(name = "ENGINE")
    private Double engine;

    @Column(name = "CAR_POWER")
    private String carPower;

    @Column(name = "CAR_STATUS")
    private CarStatus carStatus;

    @ManyToMany
    @JoinColumn(name = 'CLIENT_ID')
    private Client client;

    @ManyToOne
    @JoinColumn(name = 'RENT_ID')
    private Rent rent;
}
