package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.dto.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;
import br.com.limpacity.api.repository.MaterialRepository;
import br.com.limpacity.api.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;


    @Override
    public MaterialModel create(MaterialDTO material) {
        MaterialModel mat = materialRepository.save(toDto(material));
        return mat;
    }

    private MaterialModel toDto(MaterialDTO dto) {
        return MaterialModel.builder()
                .descricao(dto.getDescricao())
                .possuiColeta(dto.getPossuiColeta())
                .notificaColeta(dto.getNotificaColeta())
                .respColeta(dto.getRespColeta())
                .creationDate(new Date())
                .build();
    }
}
