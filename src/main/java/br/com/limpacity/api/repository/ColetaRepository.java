package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.ColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColetaRepository extends JpaRepository<ColetaModel, Long> {

    @Query(" select m from ColetaModel m " +
            " where m.sendQueue = true ")
    List<ColetaModel> findAllAndSendQueue();

}
