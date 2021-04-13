package br.com.limpacity.api.converter;

import br.com.limpacity.api.dto.EstacaoDTO;
import br.com.limpacity.api.model.EstacaoModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstacaoConverter {

    private EstacaoConverter(){
    }

    public static List<EstacaoDTO> toEstacaoList(List<EstacaoModel> estacao){
        return estacao.stream().map(EstacaoConverter::toEstacao).collect(Collectors.toList());
    }

    private static EstacaoDTO toEstacao(EstacaoModel est){
        return EstacaoDTO.builder()
                .descricao(est.getDescricao())
                .cep(est.getCep())
                .endereco(est.getEndereco())
                .numero(est.getNumero())
                .bairro(est.getBairro())
                .complemento(est.getComplemento())
                .municipio(est.getMunicipio())
                .estado(est.getEstado())
                .build();
    }
}
