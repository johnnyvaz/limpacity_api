package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.dto.ColetaQrcodeDTO;
import br.com.limpacity.api.exception.ColetaQrCodeException;
import br.com.limpacity.api.exception.PostoColetaNotFoundException;
import br.com.limpacity.api.model.ColetaQrcodeModel;
import br.com.limpacity.api.model.PostoColetaModel;
import br.com.limpacity.api.repository.ColetaInsertRepository;
import br.com.limpacity.api.repository.ColetaQrcodeRepository;
import br.com.limpacity.api.repository.PostoColetaRepository;
import br.com.limpacity.api.service.ColetaQrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ColetaQrcodeServiceImpl implements ColetaQrcodeService {

    final ColetaQrcodeRepository repository;

    final PostoColetaRepository postoColetaRepository;

    final ColetaInsertRepository coletaInsertRepository;

    @Override
    public String createQrcode(Long posto_id, ColetaQrcodeDTO obs) {
        PostoColetaModel posto = this.postoColetaRepository.findById(posto_id)
                .orElseThrow(PostoColetaNotFoundException::new);

        coletaInsertRepository.insertWithQuery(posto_id, obs.getUuid(), obs.getObservacao());
        return "Coleta Solicitada com sucesso!  - acompanhe pelo código: "
                + obs.getUuid();
    }

    public List<ColetaQrcodeModel> findAllColetasOpen(){
        final List<ColetaQrcodeModel> result = repository.findAllColetasOpen();
        if(result.isEmpty()) {
            throw new ColetaQrCodeException();
        }
        return  result;
    }

    public ColetaQrcodeModel findByUuid(String uuid){
        return repository.findByUuid(uuid);
    }

}
