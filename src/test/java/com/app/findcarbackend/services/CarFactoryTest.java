package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.repositories.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarFactoryTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    private CarFactory carFactory;

    @Test
    void shouldGetCar() {
        //Given
        Car car1 = new Car(1L, "Saab", 2011, "Manual", "Petrol", 4.4, "245 ps", CarStatus.FREE);

        CarFactory mock = org.mockito.Mockito.mock(CarFactory.class);
        when(mock.getCar("Audi", 1)).thenReturn(car1);

        mock.getCar("Audi", 1);

        //Then
        verify(mock).getCar("Audi", 1);
    }
}