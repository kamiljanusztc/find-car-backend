package com.app.findcarbackend.repositories;

import com.app.findcarbackend.domain.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long> {
}
