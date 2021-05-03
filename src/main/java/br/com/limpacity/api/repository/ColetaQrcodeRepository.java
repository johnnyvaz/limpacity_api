package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.ColetaQrcodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColetaQrcodeRepository extends JpaRepository<ColetaQrcodeModel, Long> {

    @Query(" select m from ColetaQrcodeModel m " +
            " where m.ativo = 'true' ")
    List<ColetaQrcodeModel> findAllAndIntegrationStatus();

    @Query(" select m from ColetaQrcodeModel m " +
            " where m.uuid = :uuid ")
    ColetaQrcodeModel findByUuid(String uuid);

    @Query(" select c from ColetaQrcodeModel c where " +
            " c.ativo = true and " +
            " c.integrationStatus in ('N', 'R')")
    List<ColetaQrcodeModel> findAllColetasOpen();

}
