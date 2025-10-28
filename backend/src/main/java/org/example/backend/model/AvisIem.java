package org.example.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AvisIem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvis;

    @ManyToOne
    @JoinColumn(name = "iem_id")
    private Iem iem;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commentaire_id")
    private Commentaire commentaire;

    private Integer numEtoiles;

    private LocalDateTime dateAvis;

    public Long getIdAvis() {
        return idAvis;
    }
    public void setIdAvis(Long idAvis) {
        this.idAvis = idAvis;
    }

    public Iem getIem() {
        return iem;
    }
    public void setIem(Iem iem) {
        this.iem = iem;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
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
