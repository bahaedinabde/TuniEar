package org.example.backend.mapper;

import org.example.backend.dto.NotificationDTO;
import org.example.backend.model.Client;
import org.example.backend.model.Facture;
import org.example.backend.model.Notification;

public class NotificationMapper {
    public static NotificationDTO toDTO(Notification notif) {
        NotificationDTO dto = new NotificationDTO();
        dto.setIdNotification(notif.getIdNotification());
        dto.setMessage(notif.getMessage());
        dto.setDateNotification(notif.getDateNotification());
        if(notif.getClient() != null) {
            dto.setClientId(notif.getClient().getIdUtilisateur());
        }
        if(notif.getFacture() != null) {
            dto.setFactureId(notif.getFacture().getIdFacture());
        }
        return dto;
    }
    public static Notification toEntity(NotificationDTO dto, Client clientRef, Facture factureRef) {
        Notification notif = new Notification();
        notif.setIdNotification(dto.getIdNotification());
        notif.setMessage(dto.getMessage());
        notif.setDateNotification(dto.getDateNotification());
        notif.setClient(clientRef);
        notif.setFacture(factureRef);
        return notif;
    }

}
