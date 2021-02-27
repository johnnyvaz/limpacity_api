package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstacaoDTO {

    Long id;
    String descricao;
    String cep;
    String endereco;
    String numero;
    String bairro;
    String complemento;
    String cidade;
    String estado;


}
