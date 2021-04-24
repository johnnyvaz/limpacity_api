package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.dto.ColetaQrcodeDTO;
import br.com.limpacity.api.dto.PostoColetaDTO;
import br.com.limpacity.api.exception.EstacaoNotFoundException;
import br.com.limpacity.api.exception.PostoColetaNotFoundException;
import br.com.limpacity.api.model.ColetaQrcodeModel;
import br.com.limpacity.api.model.EstacaoModel;
import br.com.limpacity.api.model.PostoColetaModel;
import br.com.limpacity.api.repository.ColetaInsertRepository;
import br.com.limpacity.api.repository.ColetaQrcodeRepository;
import br.com.limpacity.api.repository.EstacaoRepository;
import br.com.limpacity.api.repository.PostoColetaRepository;
import br.com.limpacity.api.service.ColetaQrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ColetaQrcodeServiceImpl implements ColetaQrcodeService {

    final ColetaQrcodeRepository repository;

    final PostoColetaRepository postoColetaRepository;

    final ColetaInsertRepository coletaInsertRepository;

    @Override
    public String createQrcode(Long posto_id) {
        PostoColetaModel posto = this.postoColetaRepository.findById(posto_id)
                .orElseThrow(PostoColetaNotFoundException::new);

        String uuid = UUID.randomUUID().toString();
        coletaInsertRepository.insertWithQuery(posto_id, uuid);
        return "Coleta Solicitada com sucesso!  - acompanhe pelo código: "
                + uuid;
    }


}
