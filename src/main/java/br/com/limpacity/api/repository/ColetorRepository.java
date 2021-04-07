package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.ColetorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColetorRepository extends JpaRepository<ColetorModel, Long> {

    @Query(" select m from ColetorModel m " +
            " where m.active = true ")
    List<ColetorModel> findAllAndActive();

    @Query(" select m from ColetorModel m " +
            " where m.active = true " +
            " and m.nome = :nome " +
            " and m.id = :nome ")
    List<ColetorModel> findByNameAndActive(@Param("nome") String nome);

}
