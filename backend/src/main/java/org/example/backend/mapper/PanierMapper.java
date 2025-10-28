package org.example.backend.mapper;

import org.example.backend.dto.PanierDTO;
import org.example.backend.model.Client;
import org.example.backend.model.Panier;
import org.example.backend.model.ArticlePanier;

import java.util.List;
import java.util.stream.Collectors;

public class PanierMapper {

    public static PanierDTO toDTO(Panier panier) {
        PanierDTO dto = new PanierDTO();
        dto.setIdPanier(panier.getIdPanier());
        if (panier.getClient() != null)
            dto.setClientId(panier.getClient().getIdUtilisateur());
        if (panier.getArticlesPanier() != null)
            dto.setArticlesPanierIds(
                    panier.getArticlesPanier().stream()
                            .map(ArticlePanier::getIdArticlePanier)
                            .collect(Collectors.toList()));
        if (panier.getArticlesACommander() != null)
            dto.setArticlesACommanderIds(
                    panier.getArticlesACommander().stream()
                            .map(ArticlePanier::getIdArticlePanier)
                            .collect(Collectors.toList()));
        dto.setMontantTotal(panier.getMontantTotal());
        dto.setDateExpiration(panier.getDateExpiration());
        return dto;
    }
    public static Panier toEntity(PanierDTO dto, Client clientRef, List<ArticlePanier> articlesPanierRefs, List<ArticlePanier> articlesACommanderRefs) {
        Panier panier = new Panier();
        panier.setIdPanier(dto.getIdPanier());
        panier.setClient(clientRef);

        if (dto.getArticlesPanierIds() != null) {
            panier.setArticlesPanier(articlesPanierRefs);
        }

        if (dto.getArticlesACommanderIds() != null) {
            panier.setArticlesACommander(articlesACommanderRefs);
        }

        panier.setMontantTotal(dto.getMontantTotal());
        panier.setDateExpiration(dto.getDateExpiration());
        return panier;
    }




}
