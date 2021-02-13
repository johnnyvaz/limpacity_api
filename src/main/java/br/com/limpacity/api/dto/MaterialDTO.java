package br.com.limpacity.api.dto;

import lombok.*;

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

}
