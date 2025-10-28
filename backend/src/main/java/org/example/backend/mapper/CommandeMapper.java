package org.example.backend.mapper;

import org.example.backend.dto.CommandeDTO;
import org.example.backend.model.ArticlePanier;
import org.example.backend.model.Client;
import org.example.backend.model.Commande;

import java.util.List;
import java.util.stream.Collectors;

public class CommandeMapper {
    public static CommandeDTO toDTO(Commande entity) {
        CommandeDTO dto = new CommandeDTO();
        dto.setIdCommande(entity.getIdCommande());
        dto.setNumeroCommande(entity.getNumeroCommande());
        if(entity.getClient() != null) {
            dto.setClientId(entity.getClient().getIdUtilisateur());
        }
        if(entity.getArticlesACommander() != null) {
            dto.setArticlesACommanderIds(entity.getArticlesACommander().stream().map(a -> a.getIdArticlePanier()).collect(Collectors.toList()));
        }
        dto.setMontantTotal(entity.getMontantTotal());
        dto.setDateCommande(entity.getDateCommande());
        dto.setStatut(entity.getStatut());
        return dto;
    }
    public static Commande toEntity(CommandeDTO dto, Client clientRef, List<ArticlePanier> articlesRefs) {
        Commande commande = new Commande();
        commande.setIdCommande(dto.getIdCommande());
        commande.setNumeroCommande(dto.getNumeroCommande());
        commande.setClient(clientRef);
        commande.setArticlesACommander(articlesRefs);
        commande.setMontantTotal(dto.getMontantTotal());
        commande.setDateCommande(dto.getDateCommande());
        commande.setStatut(dto.getStatut());
        return commande;
    }

}
