package org.example.backend.service;

import org.example.backend.dto.NotificationDTO;
import org.example.backend.mapper.NotificationMapper;
import org.example.backend.model.Client;
import org.example.backend.model.Facture;
import org.example.backend.model.Notification;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.FactureRepository;
import org.example.backend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FactureRepository factureRepository;

    public List<NotificationDTO> getAll() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream()
                .map(NotificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NotificationDTO getById(Long id) {
        return notificationRepository.findById(id)
                .map(NotificationMapper::toDTO)
                .orElse(null);
    }

    public NotificationDTO create(NotificationDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseThrow();
        Facture facture = factureRepository.findById(dto.getFactureId()).orElseThrow();

        Notification entity = NotificationMapper.toEntity(dto, client, facture);
        Notification saved = notificationRepository.save(entity);
        return NotificationMapper.toDTO(saved);
    }

    public NotificationDTO update(Long id, NotificationDTO dto) {
        return notificationRepository.findById(id)
                .map(existing -> {
                    Client client = clientRepository.findById(dto.getClientId()).orElseThrow();
                    Facture facture = factureRepository.findById(dto.getFactureId()).orElseThrow();

                    existing.setClient(client);
                    existing.setFacture(facture);
                    existing.setMessage(dto.getMessage());
                    existing.setDateNotification(dto.getDateNotification());

                    Notification updated = notificationRepository.save(existing);
                    return NotificationMapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}
