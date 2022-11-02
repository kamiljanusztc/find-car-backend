package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CarFactory {

    public Car getCar(String producer, int id) {


        int [] productionYearArray = {2021, 2022};
        String [] gearBoxArray = {"Automatic", "Manual"};
        String [] fuelTypeArray = {"Petrol", "Diesel", "Gas"};
        Double [] engineArray = {1.8, 2.2, 3.0, 4.4};
        String [] powerArray = {"150 ps", "220 ps", "330 ps"};

        Random random = new Random();

        int selectproductionYear = random.nextInt(productionYearArray.length);
        int selectGearbox = random.nextInt(gearBoxArray.length);
        int selectFuelType = random.nextInt(fuelTypeArray.length);
        int selectEngine = random.nextInt(engineArray.length);
        int selectPower = random.nextInt(powerArray.length);

        return new Car((long) id, producer, productionYearArray[selectproductionYear], gearBoxArray[selectGearbox], fuelTypeArray[selectFuelType], engineArray[selectEngine], powerArray[selectPower], CarStatus.FREE);
    }
}
