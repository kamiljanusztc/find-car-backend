package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.Rent;
import com.app.findcarbackend.services.CarService;
import com.app.findcarbackend.services.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/rents")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RentController {

    private final RentService rentService;

    private final CarService carService;

    @GetMapping(value = "{rentId}")
    public ResponseEntity<Optional> getClientById(@PathVariable Long rentId) {
        Rent rent = new Rent();
        rent.setId(rentId);

        return ResponseEntity.ok(rentService.getRentById(rentId));
    }

    @GetMapping
    public ResponseEntity<List<Rent>> getAllRents() {
        return ResponseEntity.ok(rentService.getAllRents());
    }

    @PostMapping("/newRent")
    @Transactional
    public ResponseEntity<Rent> createRent(@RequestBody Rent rent) {
        return ResponseEntity.ok(rentService.createRent(rent));
    }

    @PutMapping("/updateRent")
    public ResponseEntity<Rent> updateRent(Rent rent) {
        return ResponseEntity.ok(rentService.updateRent(rent));
    }

    @DeleteMapping(value = "/remove/{rentId}")
    public ResponseEntity<Boolean> deleteRent(@PathVariable Long rentId) {
        return ResponseEntity.ok(rentService.deleteRent(rentId));
    }
}
