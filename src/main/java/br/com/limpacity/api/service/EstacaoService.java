package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.EstacaoDTO;
import br.com.limpacity.api.model.EstacaoModel;

import java.util.List;

public interface EstacaoService {

    EstacaoModel create(EstacaoDTO estacao);

//    List<EstacaoDTO> findAllAndActive() throws Exception;

    EstacaoDTO updateEstacao(Long id, EstacaoDTO estacao);

    Object inactiveEstacao(Long id);

    List<EstacaoDTO> findByNameAndActive(String descricao);
}
