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
        return postoColetaRepository.save(toDto(postoColeta));
    }

    private PostoColetaModel toDto(PostoColetaDTO post) {
        return PostoColetaModel.builder()
//                .materialId(MaterialModel.builder().id(post.getMaterial().getId()).build())
//                .estacaoId(post.getEstacao())
                .observacao(post.getObservacao())
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
    public PostoColetaDTO updatePostoColeta(Long id, PostoColetaDTO postoColeta) {
        PostoColetaModel opPostoColeta = this.postoColetaRepository.findById(id)
                .orElseThrow(PostoColetaNotFoundException::new);
        Date creationDate =  opPostoColeta.getCreationDate();
        PostoColetaModel mat = postoColetaRepository.save(toUpdate(id, postoColeta, creationDate));
        return toPostoColeta(mat);
    }

    private static PostoColetaDTO toPostoColeta(PostoColetaModel post){
        return PostoColetaDTO.builder()
                .observacao(post.getObservacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .build();
    }

    private PostoColetaModel toUpdate(Long id, PostoColetaDTO post, Date creationDate) {
        return PostoColetaModel.builder()
                .observacao(post.getObservacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    @Override
    public Object inactivePostoColeta(Long id) {
        var opPostoColeta = this.postoColetaRepository.findById(id)
                .orElseThrow(PostoColetaNotFoundException::new);
        opPostoColeta.setUpdateDate(new Date());
        opPostoColeta.setActive(false);
        this.postoColetaRepository.save(opPostoColeta);
        return id;
    }

    @Override
    public List<PostoColetaDTO> findByIdAndActive(Long id) {
        final List<PostoColetaModel> result = this.postoColetaRepository.findByIdAndActive(id);
        if(result.isEmpty()){
            throw new PostoColetaNotFoundException();
        }
        return PostoColetaConverter.toPostoColetaList(result);
    }

}
