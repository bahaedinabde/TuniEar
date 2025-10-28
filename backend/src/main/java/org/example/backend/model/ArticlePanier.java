package org.example.backend.model;


import jakarta.persistence.*;

@Entity
public class ArticlePanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticlePanier;

    @ManyToOne
    @JoinColumn(name = "iem_id")
    private Iem iem;

    private Integer quantite;

    public Long getIdArticlePanier() {
        return idArticlePanier;
    }
    public void setIdArticlePanier(Long idArticlePanier) {
        this.idArticlePanier = idArticlePanier;
    }

    public Iem getIem() {

        return iem;
    }
    public void setIem(Iem iem) {
        this.iem = iem;
    }

    public Integer getQuantite() {
        return quantite;
    }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }
}
