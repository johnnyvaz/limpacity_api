package br.com.limpacity.api.controller;

import br.com.limpacity.api.dto.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;
import br.com.limpacity.api.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "MaterialController", description = "Cadastra os tipos de material ou resíduos recicláveis")
@RequestMapping(value = "/api/v1/material")
public class MaterialController {

    private final Logger logger = Logger.getLogger(MaterialController.class);

    @Autowired
    private final MaterialService materialService;

    @PostMapping
    @Operation(description = "Insere um novo material reciclável")
    public MaterialModel postMaterial(@Valid @RequestBody MaterialDTO material) {
        return this.materialService.create(material);
    }

    @GetMapping
    @Operation(description = "Busca os materiais cadastrados")
    public List<MaterialDTO> findAll() throws Exception {
        return materialService.findAllAndActive();
    }

    @PutMapping("{id}")
    @Operation(description = "Altera um material")
    public MaterialDTO updateMaterial(@PathVariable("id") Long id,
                                      @RequestBody MaterialDTO material){
        return this.materialService.updateMaterial(id, material);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Exclui um material")
    public Object inactiveMaterial(@PathVariable("id") Long id){
        String usuario = "sistema";
        logger.info(" Material id " + id + " excluido pelo usuário " + usuario);
        this.materialService.inactiveMaterial(id);
        return id;
    }
}
