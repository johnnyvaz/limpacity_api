package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.dto.ColetaQrcodeDTO;
import br.com.limpacity.api.exception.EstacaoNotFoundException;
import br.com.limpacity.api.model.ColetaQrcodeModel;
import br.com.limpacity.api.model.EstacaoModel;
import br.com.limpacity.api.repository.ColetaQrcodeRepository;
import br.com.limpacity.api.repository.EstacaoRepository;
import br.com.limpacity.api.service.ColetaQrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ColetaQrcodeServiceImpl implements ColetaQrcodeService {

    final ColetaQrcodeRepository repository;

    final EstacaoRepository estacaoRepository;

    @Override
    public ColetaQrcodeModel createQrcode(Long estacao_id) {
        EstacaoModel estacao = this.estacaoRepository.findById(estacao_id)
                .orElseThrow(EstacaoNotFoundException::new);

        return repository.save(newColetaQrcode(estacao));
    }

    private static ColetaQrcodeModel newColetaQrcode(EstacaoModel dto){
        String uuid = UUID.randomUUID().toString();
        return ColetaQrcodeModel.builder()
                .estacao(EstacaoModel.builder()
                        //.id(dto.getId())
                        .active(dto.getActive())
                        .municipio(dto.getMunicipio())
                        .bairro(dto.getBairro())
                        .cep(dto.getCep())
                        .complemento(dto.getComplemento())
                        .creationDate(dto.getCreationDate())
                        .descricao(dto.getDescricao())
                        .endereco(dto.getEndereco())
                        .estado(dto.getEstado())
                        .numero(dto.getNumero())
                        .pais(dto.getPais())
                        .build())
                .ativo(true)
                .creationDate(new Date())
                .uuid(uuid)
                .build();
    }

}
