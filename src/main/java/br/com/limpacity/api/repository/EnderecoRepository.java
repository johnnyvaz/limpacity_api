package br.com.limpacity.api.repository;

import br.com.limpacity.api.model.MunicipioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<MunicipioModel, Long> {

    @Query(" select m from MunicipioModel m " +
            " where m.habilitado = true")
    Optional<MunicipioModel> findHabilitado();

    @Query(" select m.habilitado from MunicipioModel m " +
            " where m.codMun = :codigo")
    Boolean findByCodigo(Long codigo);

    @Query(" select UPPER(m.habilitado) from MunicipioModel m " +
            " where m.nomeMunicipio like UPPER(:nome)")
    Boolean findByNome(String nome);

}
