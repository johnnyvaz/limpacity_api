package br.com.limpacity.api.dto;

import br.com.limpacity.api.dto.material.MaterialDTO;
import br.com.limpacity.api.enums.StatusInstalacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostoColetaDTO {

    MaterialDTO material;
    EstacaoDTO estacao;
    String observacao;
    String especificacao;
    StatusInstalacao statusInstalacao;
    String latitude;
    String longitude;

}