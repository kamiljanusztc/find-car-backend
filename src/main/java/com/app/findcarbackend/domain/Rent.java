package com.app.findcarbackend.domain;

import javax.validation.constraints.NotNull;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "RENTS")
public class Rent {

    @NotNull
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "RENT_ID", unique = true)
    private Long id;

    @Column(name = "DATE_START")
    private LocalDate dateStart;

    @Column(name = "DATE_END")
    private LocalDate dateEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "RENT_STATUS")
    private RentStatus rentStatus;

    @Column(name = "COST")
    private Double cost;

    @Column(name = "PAYMENT")
    private boolean isPaid;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CAR_ID")
    private Car car;
}
