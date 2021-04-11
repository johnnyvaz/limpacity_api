package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.dto.ColetaQrcodeDTO;
import br.com.limpacity.api.model.ColetaModel;

import java.util.List;
import java.util.UUID;

public interface ColetaService {

    ColetaModel create(ColetaDTO coleta);

    ColetaModel createQrcode(ColetaQrcodeDTO coleta);

    List<ColetaDTO> findAllAndIntegrationStatus() throws Exception;

    ColetaDTO updateColeta(UUID uuid, ColetaDTO coleta);

    Object inactiveColeta(UUID uuid);

}
