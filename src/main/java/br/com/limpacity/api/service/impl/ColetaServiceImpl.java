package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.ColetaConverter;
import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.exception.ColetaNotFoundException;
import br.com.limpacity.api.model.ColetaModel;
import br.com.limpacity.api.repository.ColetaRepository;
import br.com.limpacity.api.service.ColetaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ColetaServiceImpl implements ColetaService {

    final ColetaRepository coletaRepository;

    @Override
    public ColetaModel create(ColetaDTO material) {
        return coletaRepository.save(toDto(material));
    }

    private ColetaModel toDto(ColetaDTO dto) {
        return ColetaModel.builder()
                .quantidade(dto.getQuantidade())
                .integrationStatus(dto.getIntegrationStatus())
                .creationDate(new Date())
                .build();
    }

    @Override
    public List<ColetaDTO> findAllAndIntegrationStatus() {
        final List<ColetaModel> result = coletaRepository.findAllAndIntegrationStatus();

        if(result.isEmpty()){
            throw new ColetaNotFoundException();
        }
        return ColetaConverter.toColetaList(result);
    }


    public ColetaDTO updateColeta(UUID uuid, ColetaDTO material) {
        var opColeta = this.coletaRepository.findByUuid(uuid)
                .orElseThrow(ColetaNotFoundException::new);
        Date creationDate =  opColeta.getCreationDate();
        ColetaModel mat = coletaRepository.save(toUpdate(uuid, material, creationDate));
        return toColeta(mat);
    }

    private static ColetaDTO toColeta(ColetaModel dto){
        return ColetaDTO.builder()
                .uuid(dto.getUuid())
                .quantidade(dto.getQuantidade())
                .integrationStatus(dto.getIntegrationStatus())
                .build();
    }

    private ColetaModel toUpdate(UUID uuid, ColetaDTO dto, Date creationDate) {
        return ColetaModel.builder()
                .uuid(uuid)
                .quantidade(dto.getQuantidade())
                .integrationStatus(dto.getIntegrationStatus())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    public Object inactiveColeta(UUID uuid) {
        var opMaterial = this.coletaRepository.findByUuid(uuid)
                .orElseThrow(ColetaNotFoundException::new);
        opMaterial.setUpdateDate(new Date());
        opMaterial.setIntegrationStatus("N");
        this.coletaRepository.save(opMaterial);
        return uuid;
    }

}
