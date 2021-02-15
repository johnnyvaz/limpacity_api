package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.ColetadorDTO;
import br.com.limpacity.api.model.ColetadorModel;
import br.com.limpacity.api.service.ColetadorService;
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
@Tag(name = "ColetadorController", description = "Cadastra os tipos de coletador ou resíduos recicláveis")
@RequestMapping(value = "/api/v1/coletador")
public class ColetadorController extends BaseController {

    private final Logger logger = Logger.getLogger(ColetadorController.class);

    @Autowired
    private final ColetadorService coletadorService;

    @PostMapping
    @Operation(description = "Insere um novo coletador reciclável")
    public ResponseEntity<ResponseBodyDTO<ColetadorModel>> postColetador(@Valid @RequestBody ColetadorDTO coletador) {
        return buildResponseBody(coletadorService.create(coletador), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Busca os materiais cadastrados")
    public ResponseEntity<ResponseBodyDTO<ColetadorModel>> findAll() throws Exception {
        return buildResponseBody(coletadorService.findAllAndActive(), HttpStatus.OK);
    }

    @GetMapping("{nome}")
    @Operation(description = "Busca um coletador cadastrado")
    public ResponseEntity<ResponseBodyDTO<ColetadorModel>> findByName(@PathVariable("nome") String nome) {
        return buildResponseBody(coletadorService.findByNameAndActive(nome), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(description = "Altera um coletador")
    public ResponseEntity<ResponseBodyDTO<ColetadorModel>> updateColetador(@PathVariable("id") Long id,
                                      @RequestBody ColetadorDTO coletador){
        return buildResponseBody(coletadorService.updateColetador(id, coletador), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Exclui um coletador")
    public ResponseEntity<ResponseBodyDTO<ColetadorModel>> inactiveColetador(@PathVariable("id") Long id){
        String usuario = "sistema";
        logger.info(" Coletador id " + id + " excluido pelo usuário " + usuario);
        return  buildResponseBody(coletadorService.inactiveColetador(id), HttpStatus.OK);
    }
}
