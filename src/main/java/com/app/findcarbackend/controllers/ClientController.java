package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.Client;
import com.app.findcarbackend.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping(value = "{clientId}")
    public ResponseEntity<Optional> getClientById(@PathVariable Long clientId) {
        Client client = new Client();
        client.setId(clientId);

        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> createClient() {
        return ResponseEntity.ok(clientService.createClient(new Client()));
    }

    @PutMapping
    public ResponseEntity<Client> updateClient() {
        return ResponseEntity.ok(clientService.updateClient(new Client()));
    }

//    @DeleteMapping(value = "{clientId}")
//    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
//        return ResponseEntity.ok(clientService.deleteClient(clientId));
//    }
}
