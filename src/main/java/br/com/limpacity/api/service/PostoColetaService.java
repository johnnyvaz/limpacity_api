package br.com.limpacity.api.service;

import br.com.limpacity.api.dto.PostoColetaDTO;
import br.com.limpacity.api.model.PostoColetaModel;

import java.util.List;
import java.util.UUID;

public interface PostoColetaService {

    PostoColetaModel create(PostoColetaDTO material);

    List<PostoColetaDTO> findAllAndActive() throws Exception;

    List<PostoColetaModel> findTudo();

    PostoColetaDTO updatePostoColeta(Long id, PostoColetaDTO material);

    Object inactivePostoColeta(Long id);

    List<PostoColetaDTO> findByIdAndActive(Long id);
}
