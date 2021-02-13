package br.com.limpacity.api.controller;

import br.com.limpacity.api.dto.MaterialDTO;
import br.com.limpacity.api.model.MaterialModel;
import br.com.limpacity.api.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Tag(name = "MaterialController", description = "Cadastra os tipos de material ou resíduos recicláveis")
@RequestMapping(value = "/api/v1/material")
@Repository
public class MaterialController {

    @Autowired
    private final MaterialService materialService;

    @PostMapping
    @Operation(description = "Insere um novo material reciclável")
    public MaterialModel postMaterial(@Valid @RequestBody MaterialDTO material) {
        return this.materialService.create(material);
    }


}
