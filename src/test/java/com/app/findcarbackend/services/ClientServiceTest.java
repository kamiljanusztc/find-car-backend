package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Car;
import com.app.findcarbackend.domain.CarStatus;
import com.app.findcarbackend.domain.Client;
import com.app.findcarbackend.domain.LoginStatus;
import com.app.findcarbackend.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;
    @Test
    public void shouldGetClientById() {
        //Given
        Client client = new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED);

        when(clientService.getClientById(1L)).thenReturn(Optional.of(client));

        Optional<Client> clientName = clientService.getClientById(1L);

        //Then
        Assertions.assertEquals(clientName.get().getName(), client.getName());
    }

    @Test
    public void shouldGetAllClients() {
        //Given
        List<Client> clientList = List.of(new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED));

        //When
        when(clientService.getAllClients()).thenReturn(clientList);

        //Then
        Assertions.assertNotNull(clientService.getAllClients());
        Assertions.assertEquals(1, clientService.getAllClients().size());
    }

    @Test
    public void shouldCreateClient() {
        //Given
        Client client = new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED);

        when(clientService.createClient(client)).thenReturn(client);

        List<Client> clientList = new ArrayList<>();
        clientList.add(clientService.createClient(client));

        //Then
        Assertions.assertEquals(1, clientList.size());
    }

    @Test
    public void shouldClientUpdate() {
        //Given
        Client client = new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED);

        //When
        when(clientService.updateClient(client)).thenReturn(client);

        clientService.updateClient(client).setName("Mike");

        //Then
        Assertions.assertEquals(client.getName(), "Mike");
    }
    @Test
    public void shouldClientDelete() {
        //Given
        Client client = new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED);

        //When
        long clientId = client.getId();
        clientRepository.deleteById(clientId);
        boolean isExist = clientRepository.existsById(clientId);

        //Then
        Assertions.assertFalse(isExist);
    }

    @Test
    public void shouldClientSave() {
        //Given
        Client client = new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED);

        //When
        when(clientService.saveClient(client)).thenReturn(client);

        clientService.saveClient(client);

        //Then
        Assertions.assertEquals(client.getName(), "John");
    }
}