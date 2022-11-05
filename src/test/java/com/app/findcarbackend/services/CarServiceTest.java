package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.*;
import com.app.findcarbackend.repositories.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    public void shouldGetCarById() {
        //Given
        Car car1 = new Car(1L, "Saab", 2011, "Manual", "Petrol", 4.4, "245 ps", CarStatus.FREE);

        when(carService.getCarById(1L)).thenReturn(Optional.of(car1));

        Optional<Car> carModel = carService.getCarById(1L);

        //Then
        Assertions.assertEquals(carModel.get().getModel(), car1.getModel());
    }

    @Test
    public void shouldGetAllCars() {
        //Given
        List<Car> carList = List.of(new Car(1L, "Audi", 2022, "Manual", "Diesel", 4.4, "220 ps", CarStatus.FREE));

        //When
        when(carService.getAllCars()).thenReturn(carList);

        //Then
        Assertions.assertNotNull(carService.getAllCars());
        Assertions.assertEquals(1, carService.getAllCars().size());
    }

    @Test
    public void shouldAddCar() {
        //Given
        Car car1 = new Car(1L, "Saab", 2011, "Manual", "Petrol", 4.4, "245 ps", CarStatus.FREE);

        when(carService.addCar(car1)).thenReturn(car1);

        List<Car> carList = new ArrayList<>();
        carList.add(carService.addCar(car1));

        //Then
        Assertions.assertEquals(1, carList.size());
    }

    @Test
    public void shouldCarUpdate() {
        //Given
        Car car1 = new Car(1L, "Saab", 2011, "Manual", "Petrol", 4.4, "245 ps", CarStatus.FREE);

        //When
        when(carService.updateCar(car1)).thenReturn(car1);

        carService.updateCar(car1).setModel("BMW");

        //Then
        Assertions.assertEquals(car1.getModel(), "BMW");
    }

    @Test
    public void shouldCarDelete() {
        //Given
        Car car = new Car(1L, "Saab", 2011, "Manual", "Petrol", 4.4, "245 ps", CarStatus.FREE);

        //When
        long carId = car.getId();
        carRepository.deleteById(carId);
        boolean isExist = carRepository.existsById(carId);

        //Then
        Assertions.assertFalse(isExist);
    }

    @Test
    public void shouldCarSave() {
        //Given
        Car car1 = new Car(1L, "Saab", 2011, "Manual", "Petrol", 4.4, "245 ps", CarStatus.FREE);

        //When
        when(carService.saveCar(car1)).thenReturn(car1);

        carService.saveCar(car1);

        //Then
        Assertions.assertEquals(car1.getModel(), "Saab");
    }
}