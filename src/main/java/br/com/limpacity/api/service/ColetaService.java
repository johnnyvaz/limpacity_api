package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.model.ColetaModel;

import java.util.List;
import java.util.UUID;

public interface ColetaService {

    ColetaModel create(ColetaDTO coleta);

    List<ColetaDTO> findAllAndIntegrationStatus() throws Exception;

    ColetaDTO updateColeta(UUID uuid, ColetaDTO coleta);

    Object inactiveColeta(UUID uuid);

}
