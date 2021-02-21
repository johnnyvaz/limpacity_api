package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.EstacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstacaoRepository extends JpaRepository<EstacaoModel, Long> {

//    @Query(" select m from EstacaoModel m " +
//            " where m.active = true ")
//    List<EstacaoModel> findAllAndActive();

    @Query(" select e from EstacaoModel e" +
            " join e.postoColeta p")
    List<EstacaoModel> findEstacaoAndPosto();

    @Query(" select m from EstacaoModel m " +
            " where m.active = true " +
            " and m.descricao = :descricao " +
            " and m.id = :descricao ")
    List<EstacaoModel> findByNameAndActive(@Param("descricao") String descricao);
    
}
