package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.PostoColetaConverter;
import br.com.limpacity.api.dto.PostoColetaDTO;
import br.com.limpacity.api.dto.material.MaterialDTO;
import br.com.limpacity.api.exception.PostoColetaNotFoundException;
import br.com.limpacity.api.model.MaterialModel;
import br.com.limpacity.api.model.PostoColetaModel;
import br.com.limpacity.api.repository.PostoColetaRepository;
import br.com.limpacity.api.service.PostoColetaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
                .materialId(MaterialModel.builder().id(post.getMaterial().getId()).build())
//                .estacaoId()
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

    public List<PostoColetaModel> findTudo() {

        return postoColetaRepository.findTudo();
    }

    @Override
    public PostoColetaDTO updatePostoColeta(UUID uuid, PostoColetaDTO postoColeta) {
        var opPostoColeta = this.postoColetaRepository.findById(uuid)
                .orElseThrow(()-> new PostoColetaNotFoundException());
        Date creationDate =  opPostoColeta.getCreationDate();
        PostoColetaModel mat = postoColetaRepository.save(toUpdate(uuid, postoColeta, creationDate));
        return toPostoColeta(mat);
    }

    private static PostoColetaDTO toPostoColeta(PostoColetaModel post){
        return PostoColetaDTO.builder()
                .observacao(post.getObservacao())
                .especificacao(post.getEspecificacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .build();
    }

    private PostoColetaModel toUpdate(UUID uuid, PostoColetaDTO post, Date creationDate) {
        return PostoColetaModel.builder()
                .uuid(UUID.randomUUID()) // se for update deve pegar o uuid do parametro
                .observacao(post.getObservacao())
                .especificacao(post.getEspecificacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    @Override
    public Object inactivePostoColeta(UUID uuid) {
        var opPostoColeta = this.postoColetaRepository.findById(uuid)
                .orElseThrow(()-> new PostoColetaNotFoundException());
        opPostoColeta.setUpdateDate(new Date());
        opPostoColeta.setActive(false);
        this.postoColetaRepository.save(opPostoColeta);
        return uuid;
    }

    @Override
    public List<PostoColetaDTO> findByUuidAndActive(UUID uuid) {
        final List<PostoColetaModel> result = this.postoColetaRepository.findByUuidAndActive(uuid);
        if(result.isEmpty()){
            throw new PostoColetaNotFoundException();
        }
        return PostoColetaConverter.toPostoColetaList(result);
    }

}
