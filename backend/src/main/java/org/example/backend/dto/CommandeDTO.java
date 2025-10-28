package org.example.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CommandeDTO {
    private Long idCommande;
    private String numeroCommande;
    private Long clientId;
    private List<Long> articlesACommanderIds;
    private Long montantTotal;
    private LocalDateTime dateCommande;
    private String statut;

    public Long getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }
    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getArticlesACommanderIds() {
        return articlesACommanderIds;
    }
    public void setArticlesACommanderIds(List<Long> articlesACommanderIds) {
        this.articlesACommanderIds = articlesACommanderIds;
    }

    public Long getMontantTotal() {
        return montantTotal;
    }
    public void setMontantTotal(Long montantTotal) {
        this.montantTotal = montantTotal;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
}
