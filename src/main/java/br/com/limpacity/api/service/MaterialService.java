package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.material.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;

import java.util.List;

public interface MaterialService {

    MaterialModel create(MaterialDTO material);

    List<MaterialDTO> findAllAndActive() throws Exception;

    MaterialDTO updateMaterial(Long id, MaterialDTO material);

    Object inactiveMaterial(Long id);

    List<MaterialDTO> findByNameAndActive(String descricao);
}
