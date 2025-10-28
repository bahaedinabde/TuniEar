package org.example.backend.mapper;

import org.example.backend.dto.AvisIemDTO;
import org.example.backend.model.AvisIem;
import org.example.backend.model.Commentaire;
import org.example.backend.model.Client;
import org.example.backend.model.Iem;

public class AvisIemMapper {

    public static AvisIemDTO toDTO(AvisIem avis) {
        AvisIemDTO dto = new AvisIemDTO();
        dto.setIdAvis(avis.getIdAvis());

        if (avis.getIem() != null) {
            dto.setIemId(avis.getIem().getIdIem());
        }

        if (avis.getClient() != null) {
            dto.setClientId(avis.getClient().getIdUtilisateur());
        }

        if (avis.getCommentaire() != null) {
            dto.setCommentaireId(avis.getCommentaire().getIdComantaire());
            dto.setCommentaireContenu(avis.getCommentaire().getContenu());
        }

        dto.setNumEtoiles(avis.getNumEtoiles());
        dto.setDateAvis(avis.getDateAvis());

        return dto;
    }

    public static AvisIem toEntity(AvisIemDTO dto, Iem iemRef, Client clientRef, Commentaire commentaireRef) {
        AvisIem avis = new AvisIem();
        avis.setIdAvis(dto.getIdAvis());
        avis.setIem(iemRef);
        avis.setClient(clientRef);
        avis.setCommentaire(commentaireRef);
        if (dto.getCommentaireContenu() != null) {
            Commentaire com = new Commentaire();
            com.setContenu(dto.getCommentaireContenu());
            avis.setCommentaire(com);
        }

        avis.setNumEtoiles(dto.getNumEtoiles());
        avis.setDateAvis(dto.getDateAvis());
        return avis;
    }
}
