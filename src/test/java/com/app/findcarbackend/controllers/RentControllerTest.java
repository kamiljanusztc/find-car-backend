package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.*;
import com.app.findcarbackend.services.RentService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@SpringJUnitWebConfig
class RentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RentService rentService;

    @Test
    void shouldGetEmptyListOfRents() throws Exception {
        //Given
        when(rentService.getAllRents()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/rents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldFetchListOfRents() throws Exception {
        //Given
        List<Rent> rentList = List.of(new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car()));

        when(rentService.getAllRents()).thenReturn(rentList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/rents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].cost", Matchers.is(800.00)));
    }

    @Test
    void shouldFetchRent() throws Exception {
        //Given
        Rent rent = new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car());

        when(rentService.getRentById(1L)).thenReturn(Optional.of(rent));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/rents/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cost", Matchers.is(800.00)));
    }

    @Test
    public void shouldAddRent() {
        //Given
        Rent rent = new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car());

        when(rentService.addRent(rent)).thenReturn(rent);

        List<Rent> rentList = new ArrayList<>();
        rentList.add(rentService.addRent(rent));

        //Then
        Assertions.assertEquals(1, rentList.size());
    }
    @Test
    void shouldDeleteRentById() {
        List<Rent> rentList = List.of(new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car()));
        when(rentService.getAllRents()).thenReturn(rentList);

        rentService.deleteRent(1L);

        verify(rentService).deleteRent(1L);
    }
}