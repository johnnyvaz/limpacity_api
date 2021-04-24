package br.com.limpacity.api.service;

import br.com.limpacity.api.model.ColetaQrcodeModel;

import java.util.UUID;

public interface ColetaQrcodeService {

    String createQrcode(Long estacao_id);

}
