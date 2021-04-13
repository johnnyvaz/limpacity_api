package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColetorDTO {

    private Long id;

    @NotNull(message = "CPF requerido")
    private Long cpf;

    @NotNull(message = "nome requerido")
    String nome;

    Boolean active;

    Date creationDate;

}
