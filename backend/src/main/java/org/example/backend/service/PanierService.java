package org.example.backend.service;

import org.example.backend.dto.PanierDTO;
import org.example.backend.mapper.PanierMapper;
import org.example.backend.model.ArticlePanier;
import org.example.backend.model.Client;
import org.example.backend.model.Panier;
import org.example.backend.repository.ArticlePanierRepository;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ArticlePanierRepository articlePanierRepository;

    public List<PanierDTO> getAll() {
        List<Panier> paniers = panierRepository.findAll();
        return paniers.stream()
                .map(PanierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PanierDTO getById(Long id) {
        return panierRepository.findById(id)
                .map(PanierMapper::toDTO)
                .orElse(null);
    }

    public PanierDTO create(PanierDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseThrow();
        List<ArticlePanier> articlesPanier = dto.getArticlesPanierIds() != null
                ? articlePanierRepository.findAllById(dto.getArticlesPanierIds())
                : List.of();

        List<ArticlePanier> articlesACommander = dto.getArticlesACommanderIds() != null
                ? articlePanierRepository.findAllById(dto.getArticlesACommanderIds())
                : List.of();

        Panier entity = PanierMapper.toEntity(dto, client, articlesPanier, articlesACommander);
        Panier saved = panierRepository.save(entity);
        return PanierMapper.toDTO(saved);
    }

    public PanierDTO update(Long id, PanierDTO dto) {
        return panierRepository.findById(id)
                .map(existing -> {
                    Client client = clientRepository.findById(dto.getClientId()).orElseThrow();
                    List<ArticlePanier> articlesPanier = dto.getArticlesPanierIds() != null
                            ? articlePanierRepository.findAllById(dto.getArticlesPanierIds())
                            : List.of();

                    List<ArticlePanier> articlesACommander = dto.getArticlesACommanderIds() != null
                            ? articlePanierRepository.findAllById(dto.getArticlesACommanderIds())
                            : List.of();

                    existing.setClient(client);
                    existing.setArticlesPanier(articlesPanier);
                    existing.setArticlesACommander(articlesACommander);
                    existing.setMontantTotal(dto.getMontantTotal());
                    existing.setDateExpiration(dto.getDateExpiration());

                    Panier updated = panierRepository.save(existing);
                    return PanierMapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        panierRepository.deleteById(id);
    }
}
