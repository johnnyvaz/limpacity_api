package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query(" select m from UsuarioModel m " +
            " where m.active = true ")
    List<UsuarioModel> findAllAndActive();

    @Query(" select m from UsuarioModel m " +
            " where m.active = true " +
            " and m.nome = :nome ")
    List<UsuarioModel> findByNomeAndActive(@Param("nome") String nome);
    
}
