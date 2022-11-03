package com.app.findcarbackend.controllers;

import com.app.findcarbackend.domain.*;
import com.app.findcarbackend.services.ClientService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@SpringJUnitWebConfig
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ClientService clientService;

    @Test
    void shouldGetEmptyListOfClients() throws Exception {
        //Given
        when(clientService.getAllClients()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)) // or isOk()
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldFetchListOfClients() throws Exception {
        //Given
        List<Client> clientList = List.of(new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED));

        when(clientService.getAllClients()).thenReturn(clientList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Matchers.is("John")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].surname", Matchers.is("Doe")));
    }

    @Test
    void shouldFetchClient() throws Exception {
        //Given
        Client client = new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED);

        when(clientService.getClientById(1L)).thenReturn(Optional.of(client));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/v1/clients/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login", Matchers.is("j_do")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone", Matchers.is("000000000")));
    }

    @Test
    void shouldDeleteClientById() {
        List<Client> clientList = List.of(new Client(1L, "John", "Doe", "j_do", "j.doe@doe.com", "000000000", LoginStatus.LOGGED));
        when(clientService.getAllClients()).thenReturn(clientList);

        clientService.deleteClient(1L);

        verify(clientService).deleteClient(1L);
    }
}