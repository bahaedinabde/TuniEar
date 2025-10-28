package org.example.backend.dto;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Long idNotification;
    private String message;
    private LocalDateTime dateNotification;
    private Long clientId;
    private Long factureId;

    public Long getIdNotification() {
        return idNotification;

    }
    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateNotification() {
        return dateNotification;
    }
    public void setDateNotification(LocalDateTime dateNotification) {
        this.dateNotification = dateNotification;
    }

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getFactureId() {
        return factureId;
    }
    public void setFactureId(Long factureId) {
        this.factureId = factureId;
    }
}
