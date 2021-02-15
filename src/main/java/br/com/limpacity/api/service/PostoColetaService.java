package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.PostoColetaDTO;
import br.com.limpacity.api.model.PostoColetaModel;

import java.util.List;

public interface PostoColetaService {

    PostoColetaModel create(PostoColetaDTO material);

    List<PostoColetaDTO> findAllAndActive() throws Exception;

    PostoColetaDTO updatePostoColeta(Long id, PostoColetaDTO material);

    Object inactivePostoColeta(Long id);

    List<PostoColetaDTO> findByNameAndActive(String descricao);
}
