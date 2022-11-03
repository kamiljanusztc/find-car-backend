package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.repositories.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    public void shouldAddCar() {
        //Given
        Car car1 = new Car(1L, "Saab", 2011, "Manual", "Petrol", 4.4, "245 ps", CarStatus.FREE);

        when(carService.getCarById(1L)).thenReturn(Optional.of(car1));

        Optional<Car> carModel = carService.getCarById(1L);

        Assertions.assertEquals(carModel.get().getModel(), car1.getModel());
    }


}