package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColetaQrcodeDTO {

    private String uuid;
    private ColetorDTO coletor;
    private String nomeSolicitante;
    private String telefone;
    private String email;
    private String material;
    private String cep;
    private String endereco;
    private String numero;
    private String municipio;
    private String estado;
    private String pais;
    private Long quantidade;

}
