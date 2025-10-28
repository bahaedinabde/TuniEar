package org.example.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Iem {
    @Id
    private  Long idIem;


    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelIem model;

    private Long prix;

    private Integer stock;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "iem_id")
    private List<AvisIem> avis;

    public Long getIdIem() {
        return idIem;
    }


    public ModelIem getModel() {
        return model;
    }

    public void setModel(ModelIem model) {
        this.model = model;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<AvisIem> getAvis() {
        return avis;
    }

    public void setAvis(List<AvisIem> avis) {
        this.avis = avis;
    }

}
