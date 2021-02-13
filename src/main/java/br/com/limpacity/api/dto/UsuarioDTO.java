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
public class UsuarioDTO {

    private Long id;

    @NotNull(message = "Nome requerido")
    String nome;
    @NotNull(message = "Login requerido")
    String login;
    @NotNull(message = "E-mail requerido")
    String email;

}
