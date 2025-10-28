package org.example.backend.mapper;

import org.example.backend.dto.FactureDTO;
import org.example.backend.model.Commande;
import org.example.backend.model.Facture;

public class FactureMapper {
    public static FactureDTO toDTO(Facture facture) {
        FactureDTO dto = new FactureDTO();
        dto.setIdFacture(facture.getIdFacture());
        if(facture.getIdCommande() != null) {
            dto.setIdCommande(facture.getIdCommande());
        }
        dto.setDateFacture(facture.getDateFacture());
        dto.setStatus(facture.getStatus());
        return dto;
    }
    public static Facture toEntity(FactureDTO dto, Commande commandeRef) {
        Facture facture = new Facture();
        facture.setIdFacture(dto.getIdFacture());
        facture.setIdCommande(commandeRef.getIdCommande());
        facture.setDateFacture(dto.getDateFacture());
        facture.setStatus(dto.getStatus());
        return facture;
    }

}
