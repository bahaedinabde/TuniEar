package org.example.backend.repository;

import org.example.backend.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository  extends JpaRepository<Commande,Long> {
}
