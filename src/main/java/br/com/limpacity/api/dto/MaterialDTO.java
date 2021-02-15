package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {

    private Long id;

    @NotNull(message = "descricao requerido")
    String descricao;

    String possuiColeta;
    String notificaColeta;
    String respColeta;
    Boolean active;

}
