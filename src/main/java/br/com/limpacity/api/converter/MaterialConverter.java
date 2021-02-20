package br.com.limpacity.api.converter;

import br.com.limpacity.api.dto.material.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;

import java.util.List;
import java.util.stream.Collectors;

public class MaterialConverter {

    private MaterialConverter(){

    }

    public static List<MaterialDTO> toMaterialList(List<MaterialModel> material){
        return material.stream().map(MaterialConverter::toMaterial).collect(Collectors.toList());
    }

    private static MaterialDTO toMaterial(MaterialModel mat){
        return MaterialDTO.builder()
                .id(mat.getId())
                .descricao(mat.getDescricao())
                .possuiColeta(mat.getPossuiColeta())
                .notificaColeta(mat.getNotificaColeta())
                .respColeta(mat.getRespColeta())
                .active(mat.getActive())
                .build();
    }
}
