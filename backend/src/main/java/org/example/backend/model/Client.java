package org.example.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client extends Utilisateur {

    private String adresse;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<AvisIem> avis;

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<AvisIem> getAvis() {
        return avis;
    }
    public void setAvis(List<AvisIem> avis) {
        this.avis = avis;
    }
}
