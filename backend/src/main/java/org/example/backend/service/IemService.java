package org.example.backend.service;

import org.example.backend.dto.IemDTO;
import org.example.backend.mapper.IemMapper;
import org.example.backend.model.AvisIem;
import org.example.backend.model.Iem;
import org.example.backend.model.ModelIem;
import org.example.backend.repository.IemRepository;
import org.example.backend.repository.ModelIemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IemService {

    @Autowired
    private IemRepository iemRepository;

    @Autowired
    private ModelIemRepository modelIemRepository;

    @Autowired
    private AvisIemService avisIemService;

    public List<IemDTO> getAll() {
        List<Iem> iems = iemRepository.findAll();
        return iems.stream().map(IemMapper::toDTO).collect(Collectors.toList());
    }

    public IemDTO getById(Long id) {
        return iemRepository.findById(id).map(IemMapper::toDTO).orElse(null);
    }

    public IemDTO create(IemDTO dto) {
        ModelIem model = modelIemRepository.findById(dto.getModelId()).orElseThrow(() -> new RuntimeException("ModelIem not found"));

        List<AvisIem> avis = List.of();

        Iem entity = IemMapper.toEntity(dto, model, avis);
        Iem saved = iemRepository.save(entity);

        return IemMapper.toDTO(saved);
    }

    public IemDTO update(Long id, IemDTO dto) {
        return iemRepository.findById(id).map(existing -> {
            ModelIem model = modelIemRepository.findById(dto.getModelId()).orElseThrow(() -> new RuntimeException("ModelIem not found"));

            existing.setModel(model);
            existing.setPrix(dto.getPrix());
            existing.setStock(dto.getStock());

            Iem updated = iemRepository.save(existing);
            return IemMapper.toDTO(updated);
        }).orElse(null);
    }

    public void delete(Long id) {
        iemRepository.deleteById(id);
    }
}
