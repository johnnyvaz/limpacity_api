package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.ColetaConverter;
import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.exception.ColetaNotFoundException;
import br.com.limpacity.api.model.ColetaModel;
import br.com.limpacity.api.repository.ColetaRepository;
import br.com.limpacity.api.service.ColetaService;
import br.com.limpacity.api.service.NotificaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NotificaServiceImpl implements NotificaService {

    final ColetaRepository coletaRepository;

    @Override
    public String emailNotificado(UUID uuid) {
        ColetaModel emailColeta = this.coletaRepository.findByUuid(uuid)
                .orElseThrow(ColetaNotFoundException::new);
        emailColeta.setNotificaEmail(emailColeta.getNotificaEmail() + 1);
        ColetaModel mail = coletaRepository.save(emailColeta);
        return "Email enviado para o uuid: " + uuid;
    }

}
