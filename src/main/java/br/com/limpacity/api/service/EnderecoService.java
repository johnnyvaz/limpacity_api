package br.com.limpacity.api.service;

import br.com.limpacity.api.model.MunicipioModel;

import java.util.Optional;

public interface EnderecoService {

    Optional<MunicipioModel> findAllMunicipio() throws Exception;

    Boolean findByCodigo(Long codigo);

    Boolean findByNome(String nome);

}
