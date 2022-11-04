package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.*;
import com.app.findcarbackend.repositories.ClientRepository;
import com.app.findcarbackend.repositories.RentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentServiceTest {

    @Mock
    RentRepository rentRepository;

    @InjectMocks
    private RentService rentService;
    @Test
    public void shouldGetRentById() {
        //Given
        Rent rent = new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car());

        when(rentService.getRentById(1L)).thenReturn(Optional.of(rent));

        Optional<Rent> rentName = rentService.getRentById(1L);

        //Then
        Assertions.assertEquals(rentName.get().getCost(), rent.getCost());
    }

    @Test
    public void shouldGetAllRents() {
        //Given
        List<Rent> rentList = List.of(new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car()));

        //When
        when(rentService.getAllRents()).thenReturn(rentList);

        //Then
        Assertions.assertNotNull(rentService.getAllRents());
        Assertions.assertEquals(1, rentService.getAllRents().size());
    }

    @Test
    public void shouldCreateRent() {
        //Given
        Rent rent = new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car());

        when(rentService.createRent(rent)).thenReturn(rent);

        List<Rent> rentList = new ArrayList<>();
        rentList.add(rentService.createRent(rent));

        //Then
        Assertions.assertEquals(1, rentList.size());
    }

    @Test
    public void shouldRentUpdate() {
        //Given
        Rent rent = new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car());

        //When
        long rentId = rent.getId();
        when(rentService.updateRent(rent)).thenReturn(rent);

        rentService.updateRent(rent).setCost(900.00);

        //Then
        Assertions.assertEquals(rent.getCost(), 900.00);
    }

    @Test
    public void shouldRentDelete() {
        //Given
        Rent rent = new Rent(1L, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00, true, new Client(), new Car());

        //When
        long rentId = rent.getId();
        rentRepository.deleteById(rentId);
        boolean isExist = rentRepository.existsById(rentId);

        //Then
        Assertions.assertFalse(isExist);
    }
}