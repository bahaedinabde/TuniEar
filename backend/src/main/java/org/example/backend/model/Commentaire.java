package org.example.backend.model;


import jakarta.persistence.*;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComantaire;

    @Column(nullable = false)
    private String contenu;

    public Long getIdComantaire() { return idComantaire; }
    public void setIdComantaire(Long idComantaire) { this.idComantaire = idComantaire; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }
}
