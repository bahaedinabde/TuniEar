package org.example.backend.repository;

import org.example.backend.model.ArticlePanier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlePanierRepository extends JpaRepository<ArticlePanier, Long> {
}
