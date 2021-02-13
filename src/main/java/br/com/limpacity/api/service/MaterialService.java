package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;

public interface MaterialService {

    MaterialModel create(MaterialDTO material);

}
