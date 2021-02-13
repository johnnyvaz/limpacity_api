package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.MaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialModel, Long> {
}
