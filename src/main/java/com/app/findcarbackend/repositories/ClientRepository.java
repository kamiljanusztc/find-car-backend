package com.app.findcarbackend.repositories;

import com.app.findcarbackend.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
