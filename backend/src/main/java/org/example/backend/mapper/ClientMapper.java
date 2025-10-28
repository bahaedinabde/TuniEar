package org.example.backend.mapper;

import org.example.backend.dto.ClientDTO;
import org.example.backend.model.Client;

import java.util.stream.Collectors;

public class ClientMapper {
    public static ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setIdUtilisateur(client.getIdUtilisateur());
        dto.setUsername(client.getUsername());
        dto.setEmail(client.getEmail());
        dto.setAdresse(client.getAdresse());
        if (client.getCommandes() != null) {
            dto.setCommandesIds(client.getCommandes().stream().map(c -> c.getIdCommande()).collect(Collectors.toList()));
        }
        return dto;
    }
    public static Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setIdUtilisateur(dto.getIdUtilisateur());
        client.setUsername(dto.getUsername());
        client.setEmail(dto.getEmail());
        client.setPassword(dto.getPassword());
        client.setAdresse(dto.getAdresse());
        return client;
    }
}
