package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.exception.EnderecoNotFoundException;
import br.com.limpacity.api.model.MunicipioModel;
import br.com.limpacity.api.repository.EnderecoRepository;
import br.com.limpacity.api.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    final EnderecoRepository enderecoRepository;

    public Optional<MunicipioModel> findAllMunicipio() {

        final Optional<MunicipioModel> result = enderecoRepository.findHabilitado();

        if(result.isEmpty()){
            throw new EnderecoNotFoundException();
        }
        return result;
    }

    public Boolean findByCodigo(Long codigo) {
        return enderecoRepository.findByCodigo(codigo);
    }

    public Boolean findByNome(String nome) {
        return enderecoRepository.findByNome(nome);
    }

}
