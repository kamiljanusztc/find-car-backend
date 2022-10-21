package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping(value = "{carId}")
    public ResponseEntity<Optional> getCarById(@PathVariable Long carId) {
        Car car = new Car();
        car.setId(carId);

        return ResponseEntity.ok(carService.getCarById(carId));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping
    public ResponseEntity<Car> addCar() {
        return ResponseEntity.ok(carService.addCar(new Car()));
    }

    @PutMapping
    public ResponseEntity<Car> updateCar() {
        return ResponseEntity.ok(carService.updateCar(new Car()));
    }
}
