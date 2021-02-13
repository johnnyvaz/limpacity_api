package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;

import java.util.List;

public interface MaterialService {

    MaterialModel create(MaterialDTO material);

    List<MaterialDTO> findAll() throws Exception;

    MaterialDTO updateMaterial(Long id, MaterialDTO material);
}
