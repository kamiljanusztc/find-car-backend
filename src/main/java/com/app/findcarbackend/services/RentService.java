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

    private final RentRepository rentRepository;

    public Optional<Rent> getRentById(final Long rentId) { return rentRepository.findById(rentId); }

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public Rent createRent(Rent rent) {
        return rentRepository.save(rent);
    }

    public Rent addRent(Rent rent) {
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

    public Rent saveRent(Rent rent){
        return rentRepository.save(rent);
    }
}
