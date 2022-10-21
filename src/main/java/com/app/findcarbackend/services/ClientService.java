package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Client;
import com.app.findcarbackend.domain.LoginStatus;
import com.app.findcarbackend.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Optional<Client> getClientById(final Long clientId) {
        return clientRepository.findById(clientId);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        client.setName("John");
        client.setSurname("Doe");
        client.setLogin("j_doe");
        client.setEmail("j.doe@doe.com");
        client.setPhone("000000000");
        client.setLoginStatus(LoginStatus.LOGGED);
       return clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        client.setPhone("111111111");
        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
