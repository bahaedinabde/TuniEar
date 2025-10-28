package org.example.backend.service;

import org.example.backend.dto.ModelIemDTO;
import org.example.backend.mapper.ModelIemMapper;
import org.example.backend.model.ModelIem;
import org.example.backend.repository.ModelIemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ModelIemService {
    @Autowired
    private ModelIemRepository modelIemRepository;


    public List<ModelIemDTO> getAll() {
        List<ModelIem> models = modelIemRepository.findAll();
        return models.stream()
                .map(ModelIemMapper::toDTO)
                .collect(Collectors.toList());
    }
    public ModelIemDTO create(ModelIemDTO dto) {
        ModelIem entity = ModelIemMapper.toEntity(dto);
        ModelIem daved = modelIemRepository.save(entity);
        return ModelIemMapper.toDTO(daved);

    }
    public ModelIemDTO update(Long id ,ModelIemDTO dto) {
        return modelIemRepository.findById(id).map(
                existing -> {
                    existing.setNomMarque(dto.getNomMarque());
                    existing.setTypeDriver(dto.getTypeDriver());
                    existing.setFreqResponse(dto.getFreqResponse());
                    existing.setUrlsImages(dto.getUrlsImages());
                    ModelIem updated = modelIemRepository.save(existing);
                    return ModelIemMapper.toDTO(updated);
                }
        ).orElse(null);

    }
    public void delete(Long id) {
        modelIemRepository.deleteById(id);
    }
}
