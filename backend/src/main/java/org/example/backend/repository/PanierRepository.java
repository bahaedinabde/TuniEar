package org.example.backend.repository;

import org.example.backend.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository  extends JpaRepository<Panier,Long> {
}
