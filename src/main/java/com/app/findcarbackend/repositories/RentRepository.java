package com.app.findcarbackend.repositories;

import com.app.findcarbackend.domain.Client;
import com.app.findcarbackend.domain.Rent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentRepository extends CrudRepository<Rent, Long> {

    @Override
    List<Rent> findAll();
}
