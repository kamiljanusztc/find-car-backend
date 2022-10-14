package com.app.findcarbackend.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    @JoinColumn(name = 'CLIENT_ID')
    private Client client;
}
