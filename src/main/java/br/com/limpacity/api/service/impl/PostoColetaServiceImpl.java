package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.PostoColetaConverter;
import br.com.limpacity.api.dto.PostoColetaDTO;
import br.com.limpacity.api.exception.PostoColetaNotFoundException;
import br.com.limpacity.api.model.PostoColetaModel;
import br.com.limpacity.api.repository.PostoColetaRepository;
import br.com.limpacity.api.service.PostoColetaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostoColetaServiceImpl implements PostoColetaService {

    final PostoColetaRepository postoColetaRepository;

    @Override
    public PostoColetaModel create(PostoColetaDTO postoColeta) {
        PostoColetaModel post = postoColetaRepository.save(toDto(postoColeta));
        return post;
    }

    private PostoColetaModel toDto(PostoColetaDTO post) {
        return PostoColetaModel.builder()
                .qr_code(post.getQr_code())
                .observacao(post.getObservacao())
                .especificacao(post.getEspecificacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .creationDate(new Date())
                .active(true)
                .build();
    }

    @Override
    public List<PostoColetaDTO> findAllAndActive() {
        final List<PostoColetaModel> result = postoColetaRepository.findAllAndActive();

        if(result.isEmpty()){
            throw new PostoColetaNotFoundException();
        }
        return PostoColetaConverter.toPostoColetaList(result);
    }

    @Override
    public PostoColetaDTO updatePostoColeta(Long id, PostoColetaDTO postoColeta) {
        var opPostoColeta = this.postoColetaRepository.findById(id)
                .orElseThrow(()-> new PostoColetaNotFoundException());
        Date creationDate =  opPostoColeta.getCreationDate();
        PostoColetaModel mat = postoColetaRepository.save(toUpdate(id, postoColeta, creationDate));
        return toPostoColeta(mat);
    }

    private static PostoColetaDTO toPostoColeta(PostoColetaModel post){
        return PostoColetaDTO.builder()
                .qr_code(post.getQr_code())
                .observacao(post.getObservacao())
                .especificacao(post.getEspecificacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .active(post.getActive())
                .build();
    }

    private PostoColetaModel toUpdate(Long id, PostoColetaDTO post, Date creationDate) {
        return PostoColetaModel.builder()
                .id(id)
                .qr_code(post.getQr_code())
                .observacao(post.getObservacao())
                .especificacao(post.getEspecificacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .active(post.getActive())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    @Override
    public Object inactivePostoColeta(Long id) {
        var opPostoColeta = this.postoColetaRepository.findById(id)
                .orElseThrow(()-> new PostoColetaNotFoundException());
        opPostoColeta.setUpdateDate(new Date());
        opPostoColeta.setActive(false);
        this.postoColetaRepository.save(opPostoColeta);
        return id;
    }

    @Override
    public List<PostoColetaDTO> findByNameAndActive(String qr_code) {
        final List<PostoColetaModel> result = this.postoColetaRepository.findByQr_codeAndActive(qr_code);
        if(result.isEmpty()){
            throw new PostoColetaNotFoundException();

        }
        return PostoColetaConverter.toPostoColetaList(result);
    }

}
