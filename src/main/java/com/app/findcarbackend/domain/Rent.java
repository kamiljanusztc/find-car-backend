package com.app.findcarbackend.domain;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "RENTS")
public class Rent {

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "RENT_ID", unique = true)
    private Long id;

    @Column(name = "DATE_START")
    private LocalDate dateStart;

    @Column(name = "DATE_END")
    private LocalDate dateEnd;

    @Column(name = "RENT_STATUS")
    private RentStatus rentStatus;

    @Column(name = "COST")
    private Double cost;

    @Column(name = "PAYMENT")
    private boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;
}
