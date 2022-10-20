package com.app.findcarbackend.mappers;

import com.app.findcarbackend.domain.Client;
import com.app.findcarbackend.domain.ClientDto;

public class ClientMapper {

    public static ClientDto mapToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName(),
                client.getSurname(),
                client.getLogin(),
                client.getEmail(),
                client.getPhone(),
                client.getLoginStatus()
        );
    }

    public static Client mapToClient(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getName(),
                clientDto.getSurname(),
                clientDto.getLogin(),
                clientDto.getEmail(),
                clientDto.getPhone(),
                clientDto.getLoginStatus()
        );
    }
}
