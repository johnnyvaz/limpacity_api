package br.com.limpacity.api.converter;

import br.com.limpacity.api.dto.ColetorDTO;
import br.com.limpacity.api.model.ColetorModel;

import java.util.List;
import java.util.stream.Collectors;

public class ColetorConverter {

    private ColetorConverter(){

    }

    public static List<ColetorDTO> toColetorList(List<ColetorModel> coletor){
        return coletor.stream().map(ColetorConverter::toColetor).collect(Collectors.toList());
    }

    private static ColetorDTO toColetor(ColetorModel dto){
        return ColetorDTO.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .active(dto.getActive())
                .build();
    }
}
