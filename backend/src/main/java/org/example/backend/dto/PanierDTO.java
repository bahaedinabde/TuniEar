package org.example.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PanierDTO {
    private Long idPanier;
    private Long clientId;
    private List<Long> articlesPanierIds;
    private List<Long> articlesACommanderIds;
    private BigDecimal montantTotal;
    private LocalDateTime dateExpiration;

    public Long getIdPanier() {
        return idPanier;
    }
    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getArticlesPanierIds() {
        return articlesPanierIds;
    }
    public void setArticlesPanierIds(List<Long> articlesPanierIds) {
        this.articlesPanierIds = articlesPanierIds;
    }

    public List<Long> getArticlesACommanderIds() {
        return articlesACommanderIds;
    }
    public void setArticlesACommanderIds(List<Long> articlesACommanderIds) {
        this.articlesACommanderIds = articlesACommanderIds;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public LocalDateTime getDateExpiration() {
        return dateExpiration;
    }
    public void setDateExpiration(LocalDateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
