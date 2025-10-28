package org.example.backend.service;

import org.example.backend.dto.CommandeDTO;
import org.example.backend.mapper.CommandeMapper;
import org.example.backend.model.Client;
import org.example.backend.model.Commande;
import org.example.backend.model.ArticlePanier;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.CommandeRepository;
import org.example.backend.repository.ArticlePanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ArticlePanierRepository articlePanierRepository;

    public List<CommandeDTO> getAll() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandes.stream()
                .map(CommandeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CommandeDTO getById(Long id) {
        return commandeRepository.findById(id)
                .map(CommandeMapper::toDTO)
                .orElse(null);
    }

    public CommandeDTO create(CommandeDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseThrow();
        List<ArticlePanier> articles = dto.getArticlesACommanderIds() != null
                ? articlePanierRepository.findAllById(dto.getArticlesACommanderIds())
                : List.of();

        Commande entity = CommandeMapper.toEntity(dto, client, articles);
        Commande saved = commandeRepository.save(entity);
        return CommandeMapper.toDTO(saved);
    }

    public CommandeDTO update(Long id, CommandeDTO dto) {
        return commandeRepository.findById(id)
                .map(existing -> {
                    Client client = clientRepository.findById(dto.getClientId()).orElseThrow();
                    List<ArticlePanier> articles = dto.getArticlesACommanderIds() != null
                            ? articlePanierRepository.findAllById(dto.getArticlesACommanderIds())
                            : List.of();

                    existing.setNumeroCommande(dto.getNumeroCommande());
                    existing.setClient(client);
                    existing.setArticlesACommander(articles);
                    existing.setMontantTotal(dto.getMontantTotal());
                    existing.setDateCommande(dto.getDateCommande());
                    existing.setStatut(dto.getStatut());

                    Commande updated = commandeRepository.save(existing);
                    return CommandeMapper.toDTO(updated);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }
}
