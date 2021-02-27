package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.model.ColetaModel;

import java.util.List;

public interface ColetaService {

    ColetaModel create(ColetaDTO coleta);

    List<ColetaDTO> findAllAndIntegrationStatus() throws Exception;

    ColetaDTO updateColeta(Long id, ColetaDTO coleta);

    Object inactiveColeta(Long id);

}
