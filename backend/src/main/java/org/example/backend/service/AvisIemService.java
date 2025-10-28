package org.example.backend.service;

import org.example.backend.dto.AvisIemDTO;
import org.example.backend.mapper.AvisIemMapper;
import org.example.backend.model.AvisIem;
import org.example.backend.model.Client;
import org.example.backend.model.Commentaire;
import org.example.backend.model.Iem;
import org.example.backend.repository.AvisIemRepository;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.CommentaireRepository;
import org.example.backend.repository.IemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvisIemService {

    @Autowired
    private AvisIemRepository avisIemRepository;

    @Autowired
    private IemRepository iemRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    public List<AvisIemDTO> getAll() {
        List<AvisIem> avis = avisIemRepository.findAll();
        return avis.stream()
                .map(AvisIemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AvisIemDTO getById(Long id) {
        return avisIemRepository.findById(id)
                .map(AvisIemMapper::toDTO)
                .orElse(null);
    }

    public AvisIemDTO create(AvisIemDTO dto) {
        Iem iem = iemRepository.findById(dto.getIemId()).orElseThrow();
        Client client = clientRepository.findById(dto.getClientId()).orElseThrow();

        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(dto.getCommentaireContenu());
        commentaire = commentaireRepository.save(commentaire);

        AvisIem avis = AvisIemMapper.toEntity(dto, iem, client, commentaire);
        AvisIem saved = avisIemRepository.save(avis);
        return AvisIemMapper.toDTO(saved);
    }

    public AvisIemDTO update(Long id, AvisIemDTO dto) {
        return avisIemRepository.findById(id)
                .map(existing -> {
                    Iem iem = iemRepository.findById(dto.getIemId()).orElseThrow();
                    Client client = clientRepository.findById(dto.getClientId()).orElseThrow();

                    existing.setIem(iem);
                    existing.setClient(client);
                    existing.getCommentaire().setContenu(dto.getCommentaireContenu());
                    existing.setNumEtoiles(dto.getNumEtoiles());
                    existing.setDateAvis(dto.getDateAvis());

                    AvisIem updated = avisIemRepository.save(existing);
                    return AvisIemMapper.toDTO(updated);
                }).orElse(null);
    }

    public void delete(Long id) {
        avisIemRepository.deleteById(id);
    }
}
