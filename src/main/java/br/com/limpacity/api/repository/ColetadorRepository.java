package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.ColetadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColetadorRepository extends JpaRepository<ColetadorModel, Long> {

    @Query(" select m from ColetadorModel m " +
            " where m.active = true ")
    List<ColetadorModel> findAllAndActive();

    @Query(" select m from ColetadorModel m " +
            " where m.active = true " +
            " and m.nome = :nome " +
            " and m.id = :nome ")
    List<ColetadorModel> findByNameAndActive(@Param("nome") String nome);

}
