package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.ColetorConverter;
import br.com.limpacity.api.dto.ColetorDTO;
import br.com.limpacity.api.exception.ColetorNotFoundException;
import br.com.limpacity.api.model.ColetorModel;
import br.com.limpacity.api.repository.ColetorRepository;
import br.com.limpacity.api.service.ColetorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ColetorServiceImpl implements ColetorService {

    final ColetorRepository coletorRepository;

    @Override
    public ColetorModel create(ColetorDTO material) {
        ColetorModel mat = coletorRepository.save(toDto(material));
        return mat;
    }

    private ColetorModel toDto(ColetorDTO dto) {
        return ColetorModel.builder()
                .nome(dto.getNome())
                .creationDate(new Date())
                .active(true)
                .build();
    }

    @Override
    public List<ColetorDTO> findAllAndActive() {
        final List<ColetorModel> result = coletorRepository.findAllAndActive();

        if(result.isEmpty()){
            throw new ColetorNotFoundException();
        }
        return ColetorConverter.toColetorList(result);
    }

    @Override
    public ColetorDTO updateColetor(Long id, ColetorDTO material) {
        var opMaterial = this.coletorRepository.findById(id)
                .orElseThrow(ColetorNotFoundException::new);
        Date creationDate =  opMaterial.getCreationDate();
        ColetorModel mat = coletorRepository.save(toUpdate(id, material, creationDate));
        return toColetor(mat);
    }

    private static ColetorDTO toColetor(ColetorModel mat){
        return ColetorDTO.builder()
                .id(mat.getId())
                .nome(mat.getNome())
                .build();
    }

    private ColetorModel toUpdate(Long id, ColetorDTO dto, Date creationDate) {
        return ColetorModel.builder()
                .id(id)
                .nome(dto.getNome())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    @Override
    public Object inactiveColetor(Long id) {
        var opMaterial = this.coletorRepository.findById(id)
                .orElseThrow(ColetorNotFoundException::new);
        opMaterial.setUpdateDate(new Date());
        opMaterial.setActive(false);
        this.coletorRepository.save(opMaterial);
        return id;
    }

    @Override
    public List<ColetorDTO> findByNameAndActive(String nome) {
        final List<ColetorModel> result = this.coletorRepository.findByNameAndActive(nome);
        if(result.isEmpty()){
            throw new ColetorNotFoundException();

        }
        return ColetorConverter.toColetorList(result);
    }

}
