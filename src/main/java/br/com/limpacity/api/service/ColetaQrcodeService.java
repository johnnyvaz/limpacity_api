package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.ColetaQrcodeDTO;
import br.com.limpacity.api.model.ColetaQrcodeModel;

import java.util.List;

public interface ColetaQrcodeService {

    String createQrcode(Long estacao_id, ColetaQrcodeDTO obs);

    List<ColetaQrcodeModel> findAllColetasOpen();

    ColetaQrcodeModel findByUuid(String uuid);

}
