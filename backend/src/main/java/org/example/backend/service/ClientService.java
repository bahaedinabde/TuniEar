package org.example.backend.service;

import org.example.backend.dto.ClientDTO;
import org.example.backend.mapper.ClientMapper;
import org.example.backend.model.Client;
import org.example.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDTO)
                .orElse(null);
    }

    public ClientDTO create(ClientDTO dto) {
        Client client = ClientMapper.toEntity(dto);
        Client saved = clientRepository.save(client);
        return ClientMapper.toDTO(saved);
    }

    public ClientDTO update(Long id, ClientDTO dto) {
        return clientRepository.findById(id)
                .map(existing -> {
                    existing.setUsername(dto.getUsername());
                    existing.setEmail(dto.getEmail());
                    existing.setPassword(dto.getPassword());
                    existing.setAdresse(dto.getAdresse());
                    Client updated = clientRepository.save(existing);
                    return ClientMapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
