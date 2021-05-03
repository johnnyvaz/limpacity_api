package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstacaoDTO {

    UUID uuid;
    String descricao;
    String cep;
    String endereco;
    String numero;
    String bairro;
    String complemento;
    String municipio;
    String estado;


}
