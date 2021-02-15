package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.ColetadorDTO;
import br.com.limpacity.api.model.ColetadorModel;

import java.util.List;

public interface ColetadorService {

    ColetadorModel create(ColetadorDTO coletador);

    List<ColetadorDTO> findAllAndActive() throws Exception;

    ColetadorDTO updateColetador(Long id, ColetadorDTO coletador);

    Object inactiveColetador(Long id);

    List<ColetadorDTO> findByNameAndActive(String descricao);
}
