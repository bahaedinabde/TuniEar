package org.example.backend.dto;

import java.time.LocalDateTime;

public class FactureDTO {
    private Long idFacture;
    private Long idCommande;
    private LocalDateTime dateFacture;
    private String status;

    public Long getIdFacture() {
        return idFacture;
    }
    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Long getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public LocalDateTime getDateFacture() {
        return dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
