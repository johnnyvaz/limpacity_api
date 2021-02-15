package br.com.limpacity.api.converter;

import br.com.limpacity.api.dto.ColetadorDTO;
import br.com.limpacity.api.model.ColetadorModel;

import java.util.List;
import java.util.stream.Collectors;

public class ColetadorConverter {

    private ColetadorConverter(){

    }

    public static List<ColetadorDTO> toColetadorList(List<ColetadorModel> coletador){
        return coletador.stream().map(ColetadorConverter::toColetador).collect(Collectors.toList());
    }

    private static ColetadorDTO toColetador(ColetadorModel mat){
        return ColetadorDTO.builder()
                .id(mat.getId())
                .nome(mat.getNome())
                .active(mat.getActive())
                .build();
    }
}
