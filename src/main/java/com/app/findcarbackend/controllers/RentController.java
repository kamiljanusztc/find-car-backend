package com.app.findcarbackend.controllers;
import com.app.findcarbackend.domain.Rent;
import com.app.findcarbackend.services.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/rents")
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

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

    @PostMapping
    public ResponseEntity<Rent> createRent() {
        return ResponseEntity.ok(rentService.createRent(new Rent()));
    }

    @PutMapping
    public ResponseEntity<Rent> updateRent() {
        return ResponseEntity.ok(rentService.updateRent(new Rent()));
    }
}
