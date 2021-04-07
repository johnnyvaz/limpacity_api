package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.ColetorDTO;
import br.com.limpacity.api.model.ColetorModel;

import java.util.List;

public interface ColetorService {

    ColetorModel create(ColetorDTO coletador);

    List<ColetorDTO> findAllAndActive() throws Exception;

    ColetorDTO updateColetor(Long id, ColetorDTO coletor);

    Object inactiveColetor(Long id);

    List<ColetorDTO> findByNameAndActive(String descricao);
}
