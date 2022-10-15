package com.app.findcarbackend.domain;

import java.time.LocalDate;

public class RentDto {
    private Long id;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private RentStatus rentStatus;
    private Double cost;
    private Boolean isPaid;

    public RentDto(Long id, LocalDate dateStart, LocalDate dateEnd, RentStatus rentStatus, Double cost, Boolean isPaid) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.rentStatus = rentStatus;
        this.cost = cost;
        this.isPaid = isPaid;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public Double getCost() {
        return cost;
    }

    public Boolean getPaid() {
        return isPaid;
    }
}
