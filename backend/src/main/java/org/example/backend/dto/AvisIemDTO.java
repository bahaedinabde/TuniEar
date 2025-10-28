package org.example.backend.dto;

import java.time.LocalDateTime;

public class AvisIemDTO {
    private Long idAvis;

    private Long iemId;
    private Long clientId;

    private Long commentaireId;
    private String commentaireContenu;
    private Integer numEtoiles;
    private LocalDateTime dateAvis;

    public Long getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Long idAvis) {
        this.idAvis = idAvis;
    }

    public Long getIemId() {
        return iemId;
    }

    public void setIemId(Long iemId) {
        this.iemId = iemId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Long commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getCommentaireContenu() {
        return commentaireContenu;
    }

    public void setCommentaireContenu(String commentaireContenu) {
        this.commentaireContenu = commentaireContenu;
    }

    public Integer getNumEtoiles() {
        return numEtoiles;
    }

    public void setNumEtoiles(Integer numEtoiles) {
        this.numEtoiles = numEtoiles;
    }

    public LocalDateTime getDateAvis() {
        return dateAvis;
    }

    public void setDateAvis(LocalDateTime dateAvis) {
        this.dateAvis = dateAvis;
    }
}
