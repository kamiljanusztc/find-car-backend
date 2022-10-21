package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Optional<Car> getCarById(final Long carId) {
        return carRepository.findById(carId);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        car.setModel("Audi");
        car.setYear(2022);
        car.setGearBox("Automatic");
        car.setFuelType("Petrol");
        car.setEngine(2.0);
        car.setCarPower("245 ps");
        car.setCarStatus(CarStatus.FREE);
        return carRepository.save(car);
    }

    public Car updateCar(Car car) {
        car.setCarStatus(CarStatus.RENTED);
        return carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
