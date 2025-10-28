package org.example.backend.mapper;

import org.example.backend.dto.ModelIemDTO;
import org.example.backend.model.ModelIem;

public class ModelIemMapper {
    public static ModelIemDTO toDTO(ModelIem entity) {
        ModelIemDTO dto = new ModelIemDTO();
        dto.setIdModel(entity.getIdModel());
        dto.setNomMarque(entity.getNomMarque());
        dto.setTypeDriver(entity.getTypeDriver());
        dto.setFreqResponse(entity.getFreqResponse());
        dto.setUrlsImages(entity.getUrlsImages());
        return dto;
    }

    public static ModelIem toEntity(ModelIemDTO dto) {
        ModelIem entity = new ModelIem();
        entity.setIdModel(dto.getIdModel());
        entity.setNomMarque(dto.getNomMarque());
        entity.setTypeDriver(dto.getTypeDriver());
        entity.setFreqResponse(dto.getFreqResponse());
        entity.setUrlsImages(dto.getUrlsImages());
        return entity;
    }

}
