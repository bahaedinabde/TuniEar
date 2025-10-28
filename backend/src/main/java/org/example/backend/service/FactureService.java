package org.example.backend.service;

import org.example.backend.dto.FactureDTO;
import org.example.backend.mapper.FactureMapper;
import org.example.backend.model.Commande;
import org.example.backend.model.Facture;
import org.example.backend.repository.CommandeRepository;
import org.example.backend.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    public List<FactureDTO> getAll() {
        List<Facture> factures = factureRepository.findAll();
        return factures.stream()
                .map(FactureMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FactureDTO getById(Long id) {
        return factureRepository.findById(id)
                .map(FactureMapper::toDTO)
                .orElse(null);
    }

    public FactureDTO create(FactureDTO dto) {
        Commande commande = commandeRepository.findById(dto.getIdCommande()).orElseThrow();

        Facture entity = FactureMapper.toEntity(dto, commande);
        Facture saved = factureRepository.save(entity);
        return FactureMapper.toDTO(saved);
    }

    public FactureDTO update(Long id, FactureDTO dto) {
        return factureRepository.findById(id)
                .map(existing -> {
                    Commande commande = commandeRepository.findById(dto.getIdCommande()).orElseThrow();
                    existing.setIdCommande(commande.getIdCommande());
                    existing.setDateFacture(dto.getDateFacture());
                    existing.setStatus(dto.getStatus());

                    Facture updated = factureRepository.save(existing);
                    return FactureMapper.toDTO(updated);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        factureRepository.deleteById(id);
    }
}
