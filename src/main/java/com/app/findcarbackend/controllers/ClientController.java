package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.Client;
import com.app.findcarbackend.repositories.ClientRepository;
import com.app.findcarbackend.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

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

    @PostMapping("/newClient")
    Client addUser(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/updateClient")
    public ResponseEntity<Client> updateClient(Client client) {
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping(value = "/remove/{clientId}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.deleteClient(clientId));
    }
}
