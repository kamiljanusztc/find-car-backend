package com.app.findcarbackend.domain;

import javax.validation.constraints.NotNull;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
@Data
@Entity(name = "CARS")
public class Car {

    @NotNull
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CAR_ID", unique = true)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PRODUCTION_YEAR")
    private Integer productionYear;

    @Column(name = "GEARBOX")
    private String gearBox;

    @Column(name = "FUEL_TYPE")
    private String fuelType;

    @Column(name = "ENGINE")
    private Double engine;

    @Column(name = "CAR_POWER")
    private String carPower;

    @Enumerated(EnumType.STRING)
    @Column(name = "CAR_STATUS")
    private CarStatus carStatus;
}
