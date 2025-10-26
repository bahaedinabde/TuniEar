package org.example.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    private String numeroCommande;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "commande_id")
    private List<ArticlePanier> articlesACommander;

    private Long montantTotal;

    private LocalDateTime dateCommande;

    private String statut;

    private String adresseLivraison;

    // ----- Getters et Setters -----
    public Long getIdCommande() { return idCommande; }
    public void setIdCommande(Long idCommande) { this.idCommande = idCommande; }

    public String getNumeroCommande() { return numeroCommande; }
    public void setNumeroCommande(String numeroCommande) { this.numeroCommande = numeroCommande; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<ArticlePanier> getArticlesACommander() { return articlesACommander; }
    public void setArticlesACommander(List<ArticlePanier> articlesACommander) { this.articlesACommander = articlesACommander; }

    public Long getMontantTotal() { return montantTotal; }
    public void setMontantTotal(Long montantTotal) { this.montantTotal = montantTotal; }

    public LocalDateTime getDateCommande() { return dateCommande; }
    public void setDateCommande(LocalDateTime dateCommande) { this.dateCommande = dateCommande; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }
}
