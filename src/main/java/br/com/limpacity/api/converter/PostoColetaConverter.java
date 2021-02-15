package br.com.limpacity.api.converter;

import br.com.limpacity.api.dto.PostoColetaDTO;
import br.com.limpacity.api.model.PostoColetaModel;

import java.util.List;
import java.util.stream.Collectors;

public class PostoColetaConverter {

    private PostoColetaConverter(){

    }

    public static List<PostoColetaDTO> toPostoColetaList(List<PostoColetaModel> posto){
        return posto.stream().map(PostoColetaConverter::toPostoColeta).collect(Collectors.toList());
    }

    private static PostoColetaDTO toPostoColeta(PostoColetaModel post){
        return PostoColetaDTO.builder()
                .id(post.getId())
                .qr_code(post.getQr_code())
                .observacao(post.getObservacao())
                .especificacao(post.getEspecificacao())
                .statusInstalacao(post.getStatusInstalacao())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .active(post.getActive())
                .build();
    }
}
