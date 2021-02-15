package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.ColetadorConverter;
import br.com.limpacity.api.dto.ColetadorDTO;
import br.com.limpacity.api.exception.ColetadorNotFoundException;
import br.com.limpacity.api.model.ColetadorModel;
import br.com.limpacity.api.repository.ColetadorRepository;
import br.com.limpacity.api.service.ColetadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ColetadorServiceImpl implements ColetadorService {

    final ColetadorRepository coletadorRepository;

    @Override
    public ColetadorModel create(ColetadorDTO material) {
        ColetadorModel mat = coletadorRepository.save(toDto(material));
        return mat;
    }

    private ColetadorModel toDto(ColetadorDTO dto) {
        return ColetadorModel.builder()
                .nome(dto.getNome())
                .creationDate(new Date())
                .active(true)
                .build();
    }

    @Override
    public List<ColetadorDTO> findAllAndActive() {
        final List<ColetadorModel> result = coletadorRepository.findAllAndActive();

        if(result.isEmpty()){
            throw new ColetadorNotFoundException();
        }
        return ColetadorConverter.toColetadorList(result);
    }

    @Override
    public ColetadorDTO updateColetador(Long id, ColetadorDTO material) {
        var opMaterial = this.coletadorRepository.findById(id)
                .orElseThrow(()-> new ColetadorNotFoundException());
        Date creationDate =  opMaterial.getCreationDate();
        ColetadorModel mat = coletadorRepository.save(toUpdate(id, material, creationDate));
        return toColetador(mat);
    }

    private static ColetadorDTO toColetador(ColetadorModel mat){
        return ColetadorDTO.builder()
                .id(mat.getId())
                .nome(mat.getNome())
                .build();
    }

    private ColetadorModel toUpdate(Long id, ColetadorDTO dto, Date creationDate) {
        return ColetadorModel.builder()
                .id(id)
                .nome(dto.getNome())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    @Override
    public Object inactiveColetador(Long id) {
        var opMaterial = this.coletadorRepository.findById(id)
                .orElseThrow(()-> new ColetadorNotFoundException());
        opMaterial.setUpdateDate(new Date());
        opMaterial.setActive(false);
        this.coletadorRepository.save(opMaterial);
        return id;
    }

    @Override
    public List<ColetadorDTO> findByNameAndActive(String nome) {
        final List<ColetadorModel> result = this.coletadorRepository.findByNameAndActive(nome);
        if(result.isEmpty()){
            throw new ColetadorNotFoundException();

        }
        return ColetadorConverter.toColetadorList(result);
    }

}
