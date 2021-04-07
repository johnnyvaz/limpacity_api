package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.ColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ColetaRepository extends JpaRepository<ColetaModel, Long> {

    @Query(" select m from ColetaModel m " +
            " where m.integrationStatus = 'N' ")
    List<ColetaModel> findAllAndIntegrationStatus();

    @Query(" select m from ColetaModel m " +
            " where m.uuid = :uuid ")
    Optional<ColetaModel> findByUuid(UUID uuid);
}
