package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.EstacaoConverter;
import br.com.limpacity.api.dto.EstacaoDTO;
import br.com.limpacity.api.exception.EstacaoNotFoundException;
import br.com.limpacity.api.model.EstacaoModel;
import br.com.limpacity.api.repository.EstacaoRepository;
import br.com.limpacity.api.service.EstacaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EstacaoServiceImpl implements EstacaoService {

    final EstacaoRepository estacaoRepository;

    @Override
    public EstacaoModel create(EstacaoDTO estacao) {
        return estacaoRepository.save(toDto(estacao));
    }

    private EstacaoModel toDto(EstacaoDTO est) {
        return EstacaoModel.builder()
                .descricao(est.getDescricao())
                .cep(est.getCep())
                .endereco(est.getEndereco())
                .numero(est.getNumero())
                .bairro(est.getBairro())
                .complemento(est.getComplemento())
                .municipio(est.getMunicipio())
                .estado(est.getEstado())
                .creationDate(new Date())
                .active(true)
                .build();
    }

//    @Override
//    public List<EstacaoDTO> findAllAndActive() {
//        final List<EstacaoModel> result = estacaoRepository.findEstacaoAndPosto();
//
//        if(result.isEmpty()){
//            throw new EstacaoNotFoundException();
//        }
//        return EstacaoConverter.toEstacaoList(result);
//    }

    @Override
    public EstacaoDTO updateEstacao(Long id, EstacaoDTO estacao) {
        EstacaoModel opEstacao = this.estacaoRepository.findById(id)
                .orElseThrow(EstacaoNotFoundException::new);
        Date creationDate =  opEstacao.getCreationDate();
        EstacaoModel est = estacaoRepository.save(toUpdate(id, estacao, creationDate));
        return toEstacao(est);
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

    private EstacaoModel toUpdate(Long id, EstacaoDTO est, Date creationDate) {
        return EstacaoModel.builder()
                .id(id)
                .descricao(est.getDescricao())
                .cep(est.getCep())
                .endereco(est.getEndereco())
                .numero(est.getNumero())
                .bairro(est.getBairro())
                .complemento(est.getComplemento())
                .municipio(est.getMunicipio())
                .estado(est.getEstado())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    @Override
    public Object inactiveEstacao(Long id) {
        EstacaoModel opEstacao = this.estacaoRepository.findById(id)
                .orElseThrow(EstacaoNotFoundException::new);
        opEstacao.setUpdateDate(new Date());
        opEstacao.setActive(false);
        this.estacaoRepository.save(opEstacao);
        return id;
    }

    @Override
    public List<EstacaoDTO> findByNameAndActive(String descricao) {
        final List<EstacaoModel> result = this.estacaoRepository.findByNameAndActive(descricao);
        if(result.isEmpty()){
            throw new EstacaoNotFoundException();

        }
        return EstacaoConverter.toEstacaoList(result);
    }

}
