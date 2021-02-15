package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;
import br.com.limpacity.api.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Tag(name = "MaterialController", description = "Cadastra os tipos de material ou resíduos recicláveis")
@RequestMapping(value = "/api/v1/material")
public class MaterialController extends BaseController {

    private final Logger logger = Logger.getLogger(MaterialController.class);

    @Autowired
    private final MaterialService materialService;

    @PostMapping
    @Operation(description = "Insere um novo material reciclável")
    public ResponseEntity<ResponseBodyDTO<MaterialModel>> postMaterial(@Valid @RequestBody MaterialDTO material) {
        return buildResponseBody(materialService.create(material), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Busca os materiais cadastrados")
    public ResponseEntity<ResponseBodyDTO<MaterialModel>> findAll() throws Exception {
        return buildResponseBody(materialService.findAllAndActive(), HttpStatus.OK);
    }

    @GetMapping("{descricao}")
    @Operation(description = "Busca um material cadastrado")
    public ResponseEntity<ResponseBodyDTO<MaterialModel>> findByName(@PathVariable("descricao") String descricao) {
        return buildResponseBody(materialService.findByNameAndActive(descricao), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(description = "Altera um material")
    public ResponseEntity<ResponseBodyDTO<MaterialModel>> updateMaterial(@PathVariable("id") Long id,
                                      @RequestBody MaterialDTO material){
        return buildResponseBody(materialService.updateMaterial(id, material), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Exclui um material")
    public ResponseEntity<ResponseBodyDTO<MaterialModel>> inactiveMaterial(@PathVariable("id") Long id){
        String usuario = "sistema";
        logger.info(" Material id " + id + " excluido pelo usuário " + usuario);
        return  buildResponseBody(materialService.inactiveMaterial(id), HttpStatus.OK);
    }
}
