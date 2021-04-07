package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.ColetorDTO;
import br.com.limpacity.api.model.ColetorModel;
import br.com.limpacity.api.service.ColetorService;
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
@Tag(name = "ColetorController", description = "Cadastra os tipos de coletor ou resíduos recicláveis")
@RequestMapping(value = "/api/v1/coletor")
public class ColetorController extends BaseController {

    private final Logger logger = Logger.getLogger(ColetorController.class);

    @Autowired
    private final ColetorService coletorService;

    @PostMapping
    @Operation(description = "Insere um novo coletor reciclável")
    public ResponseEntity<ResponseBodyDTO<ColetorModel>> postColetador(@Valid @RequestBody ColetorDTO coletador) {
        return buildResponseBody(coletorService.create(coletador), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Busca os materiais cadastrados")
    public ResponseEntity<ResponseBodyDTO<ColetorModel>> findAll() throws Exception {
        return buildResponseBody(coletorService.findAllAndActive(), HttpStatus.OK);
    }

    @GetMapping("{nome}")
    @Operation(description = "Busca um coletor cadastrado")
    public ResponseEntity<ResponseBodyDTO<ColetorModel>> findByName(@PathVariable("nome") String nome) {
        return buildResponseBody(coletorService.findByNameAndActive(nome), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(description = "Altera um coletor")
    public ResponseEntity<ResponseBodyDTO<ColetorModel>> updateColetor(@PathVariable("id") Long id,
                                                                         @RequestBody ColetorDTO coletador){
        return buildResponseBody(coletorService.updateColetor(id, coletador), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Exclui um coletor")
    public ResponseEntity<ResponseBodyDTO<ColetorModel>> inactiveColetor(@PathVariable("id") Long id){
        String usuario = "sistema";
        logger.info(" Coletor id " + id + " excluído pelo usuário " + usuario);
        return  buildResponseBody(coletorService.inactiveColetor(id), HttpStatus.OK);
    }
}
