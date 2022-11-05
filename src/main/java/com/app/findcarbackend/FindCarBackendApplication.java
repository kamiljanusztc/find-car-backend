package com.app.findcarbackend;

import com.app.findcarbackend.domain.*;
import com.app.findcarbackend.repositories.CarRepository;
import com.app.findcarbackend.repositories.ClientRepository;
import com.app.findcarbackend.repositories.RentRepository;
import com.app.findcarbackend.services.CarFactory;
import com.app.findcarbackend.services.CarRetriever;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class FindCarBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindCarBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ClientRepository clientRepository, CarRepository carRepository, RentRepository rentRepository, CarRetriever carRetriever, CarFactory carFactory) {
        final Client[] client1 = new Client[1];
        final Car[] car1 = new Car[1];

        return args -> {
            for (int i = 0; i < 10; i++) {
                Client client = new Client((long) i, "John_" + i, "Julie_" + i, "j_ju", "j.ju@ju.com", "000000000", LoginStatus.LOGGED);
                client1[0] = client;
                clientRepository.save(client);
            }
            clientRepository.findAll().forEach(System.out::println);


            ApiCarResponseObject apiCars = carRetriever.getCarsFromApi();
            List<ApiCar> data = apiCars.getData();
            for (int i = 0; i < data.size(); i++) {
                ApiCar apiCar = data.get(i);
                Car car = carFactory.getCar(apiCar.getName(), apiCar.getId());
                car1[0] = car;
                carRepository.save(car);
                carRepository.findAll().forEach(System.out::println);

            }

            for (int i = 0; i < 10; i++) {
                Rent rent = new Rent((long) i, LocalDate.of(2022, 05, 01), LocalDate.of(2022, 05, 02), RentStatus.IN_PROGRESS, 800.00 + i, true, client1[0], car1[0]);
                rentRepository.save(rent);
            }
            rentRepository.findAll().forEach(System.out::println);
        };
    }
}
