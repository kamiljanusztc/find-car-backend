package com.app.findcarbackend.services;
import com.app.findcarbackend.domain.*;
import com.app.findcarbackend.repositories.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentService {

    RentRepository rentRepository;

    public Optional<Rent> getRentById(final Long rentId) { return rentRepository.findById(rentId); }

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public Rent createRent(Rent rent) {
        rent.setDateStart(LocalDate.of(2022, 1, 13));
        rent.setDateEnd(LocalDate.of(2022, 1, 15));
        rent.setCost(600.00);
        rent.setPaid(false);
        rent.setClient(new Client(1L, "John", "Doe", "j_doe", "j.doe@doe.com", "000000000", LoginStatus.LOGGED));
        rent.setCar(new Car());
        return rentRepository.save(rent);
    }

    public Rent updateRent(Rent rent) {
        rent.setCost(550.00);
        return rentRepository.save(rent);
    }

    public boolean deleteRent(Long rentId) {
        rentRepository.deleteById(rentId);
        return true;
    }
}
