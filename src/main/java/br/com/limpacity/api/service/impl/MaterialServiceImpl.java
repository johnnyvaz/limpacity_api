package br.com.limpacity.api.service.impl;

import br.com.limpacity.api.converter.MaterialConverter;
import br.com.limpacity.api.dto.material.MaterialDTO;
import br.com.limpacity.api.exception.MaterialIdNotFoundException;
import br.com.limpacity.api.exception.MaterialNotFoundException;
import br.com.limpacity.api.model.MaterialModel;
import br.com.limpacity.api.repository.MaterialRepository;
import br.com.limpacity.api.service.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    final MaterialRepository materialRepository;

    @Override
    public MaterialModel create(MaterialDTO material) {
        return materialRepository.save(toDto(material));
    }

    private MaterialModel toDto(MaterialDTO dto) {
        return MaterialModel.builder()
                .descricao(dto.getDescricao())

                .creationDate(new Date())
                .active(true)
                .build();
    }

    @Override
    public List<MaterialDTO> findAllAndActive() {
        final List<MaterialModel> result = materialRepository.findAllAndActive();

        if(result.isEmpty()){
            throw new MaterialNotFoundException();
        }
        return MaterialConverter.toMaterialList(result);
    }

    @Override
    public MaterialDTO updateMaterial(Long id, MaterialDTO material) {
        var opMaterial = this.materialRepository.findById(id)
                .orElseThrow(()-> new MaterialIdNotFoundException(id));
        Date creationDate =  opMaterial.getCreationDate();
        MaterialModel mat = materialRepository.save(toUpdate(id, material, creationDate));
        return toMaterial(mat);
    }

    private static MaterialDTO toMaterial(MaterialModel mat){
        return MaterialDTO.builder()
                .id(mat.getId())
                .descricao(mat.getDescricao())
                .active(mat.getActive())
                .build();
    }

    private MaterialModel toUpdate(Long id, MaterialDTO dto, Date creationDate) {
        return MaterialModel.builder()
                .id(id)
                .descricao(dto.getDescricao())
                .active(dto.getActive())
                .creationDate(creationDate)
                .updateDate(new Date())
                .build();
    }

    @Override
    public Object inactiveMaterial(Long id) {
        MaterialModel opMaterial;
        opMaterial = this.materialRepository.findById(id)
                .orElseThrow(()-> new MaterialIdNotFoundException(id));
        opMaterial.setUpdateDate(new Date());
        opMaterial.setActive(false);
        this.materialRepository.save(opMaterial);
        return id;
    }

    @Override
    public List<MaterialDTO> findByNameAndActive(String descricao) {
        final List<MaterialModel> result = this.materialRepository.findByNameAndActive(descricao);
        if(result.isEmpty()){
            throw new MaterialNotFoundException();
        }
        return MaterialConverter.toMaterialList(result);
    }

}
