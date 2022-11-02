package com.app.findcarbackend.domain;

public class CarDto {
    private Long id;
    private String model;
    private Integer year;
    private String gearBox;
    private String fuelType;
    private Double engine;
    private String carPower;
    private CarStatus carStatus;

    public CarDto(Long id, String model, Integer year, String gearBox, String fuelType, Double engine, String carPower, CarStatus carStatus) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.gearBox = gearBox;
        this.fuelType = fuelType;
        this.engine = engine;
        this.carPower = carPower;
        this.carStatus = carStatus;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getGearBox() {
        return gearBox;
    }

    public String getFuelType() {
        return fuelType;
    }

    public Double getEngine() {
        return engine;
    }

    public String getCarPower() {
        return carPower;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }
}
