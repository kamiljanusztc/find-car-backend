package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Client;
import com.app.findcarbackend.domain.ClientDto;
import com.app.findcarbackend.mappers.ClientMapper;
import com.app.findcarbackend.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.app.findcarbackend.mappers.ClientMapper.mapToClient;
import static com.app.findcarbackend.mappers.ClientMapper.mapToDto;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public ClientDto createClient(ClientDto clientDto) {

        Client savedClient = clientRepository.save(mapToClient(clientDto));
        return mapToDto(savedClient);
    }

}
