package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.MaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialModel, Long> {

    @Query(" select m from MaterialModel m " +
            " where m.active = true ")
    List<MaterialModel> findAllAndActive();

    @Query(" select m from MaterialModel m " +
            " where m.id = :id ")
    Optional<MaterialModel> findByUuid(@Param("id") Long id);

    @Query(" select m from MaterialModel m " +
            " where m.active = true " +
            " and m.descricao = :descricao ")
    List<MaterialModel> findByNameAndActive(@Param("descricao") String descricao);

}
