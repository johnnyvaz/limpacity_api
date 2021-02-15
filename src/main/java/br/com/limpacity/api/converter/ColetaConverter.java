package br.com.limpacity.api.converter;

import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.dto.ColetadorDTO;
import br.com.limpacity.api.model.ColetaModel;
import br.com.limpacity.api.model.ColetadorModel;

import java.util.List;
import java.util.stream.Collectors;

public class ColetaConverter {

    private ColetaConverter(){

    }

    public static List<ColetaDTO> toColetaList(List<ColetaModel> coleta){
        return coleta.stream().map(ColetaConverter::toColeta).collect(Collectors.toList());
    }

    private static ColetaDTO toColeta(ColetaModel mat){
        return ColetaDTO.builder()
                .id(mat.getId())
                .quantidade(mat.getQuantidade())
                .sendQueue(mat.getSendQueue())
                .build();
    }
}
