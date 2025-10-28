package org.example.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;
    private BigDecimal montantTotal;


    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "panier_id")
    private List<ArticlePanier> articlesPanier;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "articles_commande_id")
    private List<ArticlePanier> articlesACommander;

    private LocalDateTime dateExpiration;

    public Long getIdPanier() {
        return idPanier;
    }
    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }
    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {

        this.montantTotal = montantTotal;
    }
    public Client getClient() {

        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public List<ArticlePanier> getArticlesPanier() {
        return articlesPanier;
    }
    public void setArticlesPanier(List<ArticlePanier> articlesPanier) {
        this.articlesPanier = articlesPanier;
    }

    public List<ArticlePanier> getArticlesACommander() {
        return articlesACommander;
    }
    public void setArticlesACommander(List<ArticlePanier> articlesACommander) {
        this.articlesACommander = articlesACommander;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }
    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
