package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.services.CarService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@SpringJUnitWebConfig
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CarService carService;


    @Test
    void shouldGetEmptyListOfCars() throws Exception {
        //Given
        when(carService.getAllCars()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldFetchListOfCars() throws Exception {
        //Given
        List<Car> carList = List.of(new Car(1L, "Audi", 2022, "Manual", "Diesel", 4.4, "220 ps", CarStatus.FREE));

        when(carService.getAllCars()).thenReturn(carList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].model", Matchers.is("Audi")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productionYear", Matchers.is(2022)));
    }

    @Test
    void shouldFetchCar() throws Exception {
        //Given
        Car car = new Car(1L, "Audi", 2022, "Manual", "Diesel", 4.4, "220 ps", CarStatus.FREE);

        when(carService.getCarById(1L)).thenReturn(Optional.of(car));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/cars/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gearBox", Matchers.is("Manual")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.engine", Matchers.is(4.4)));
    }

    @Test
    void shouldAddCar() {
        Car car = new Car(1L, "Audi", 2022, "Manual", "Diesel", 4.4, "220 ps", CarStatus.FREE);
        when(carService.addCar(car)).thenReturn(car);

        carService.addCar(car);

        verify(carService).addCar(car);
    }
    @Test
    void shouldDeleteCarById() {
        List<Car> carList = List.of(new Car(1L, "Audi", 2022, "Manual", "Diesel", 4.4, "220 ps", CarStatus.FREE));
        when(carService.getAllCars()).thenReturn(carList);

        carService.deleteCar(1L);

        verify(carService).deleteCar(1L);
    }
}