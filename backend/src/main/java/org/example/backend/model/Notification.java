package org.example.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;

    private String message;

    private LocalDateTime dateNotification;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "facture_id", nullable = true)
    private Facture facture;

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

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Facture getFacture() {
        return facture;
    }
    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
