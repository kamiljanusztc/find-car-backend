package com.app.findcarbackend.repositories;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    List<Car> findAll();
}
