package org.example.backend.repository;

import org.example.backend.model.ModelIem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelIemRepository extends JpaRepository<ModelIem, Long> {
}
