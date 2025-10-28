package org.example.backend.mapper;

import org.example.backend.dto.IemDTO;
import org.example.backend.model.Iem;
import org.example.backend.model.ModelIem;
import org.example.backend.model.AvisIem;

import java.util.List;
import java.util.stream.Collectors;

public class IemMapper {
    public static IemDTO toDTO(Iem iem) {
        IemDTO dto = new IemDTO();
        dto.setPrix(iem.getPrix());
        dto.setStock(iem.getStock());

        if (iem.getModel() != null) {
            dto.setModelId(iem.getModel().getIdModel());
            dto.setNomMarque(iem.getModel().getNomMarque());
            dto.setTypeDriver(iem.getModel().getTypeDriver());
            dto.setFreqResponse(iem.getModel().getFreqResponse());
            dto.setUrlsImages(iem.getModel().getUrlsImages());
        }

        if (iem.getAvis() != null) {
            List<Long> avisIds = iem.getAvis().stream()
                    .map(AvisIem::getIdAvis)
                    .collect(Collectors.toList());
            dto.setAvisIds(avisIds);
        }
        return dto;
    }

    public static Iem toEntity(IemDTO dto, ModelIem modelRef, List<AvisIem> avisRefs) {
        Iem iem = new Iem();
        iem.setModel(modelRef);
        iem.setPrix(dto.getPrix());
        iem.setStock(dto.getStock());
        iem.setAvis(avisRefs);
        return iem;
    }
}
