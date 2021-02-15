package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColetadorDTO {

    private Long id;

    @NotNull(message = "nome requerido")
    String nome;

    Boolean active;

    Date creationDate;

}
