package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.model.ColetaModel;
import br.com.limpacity.api.service.ColetaService;
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
@Tag(name = "ColetaController", description = " (verificar o que faz sentido) para solicitação de coleta")
@RequestMapping(value = "/api/v1/coleta")
public class ColetaController extends BaseController {

    private final Logger logger = Logger.getLogger(ColetaController.class);

    @Autowired
    private final ColetaService coletaService;

    @PostMapping
    @Operation(description = "Insere um novo coleta reciclável")
    public ResponseEntity<ResponseBodyDTO<ColetaModel>> postColeta(@Valid @RequestBody ColetaDTO coleta) {
        return buildResponseBody(coletaService.create(coleta), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Busca os materiais cadastrados")
    public ResponseEntity<ResponseBodyDTO<ColetaModel>> findAll() throws Exception {
        return buildResponseBody(coletaService.findAllAndSendQueue(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(description = "Altera um coleta")
    public ResponseEntity<ResponseBodyDTO<ColetaModel>> updateColeta(@PathVariable("id") Long id,
                                      @RequestBody ColetaDTO coleta){
        return buildResponseBody(coletaService.updateColeta(id, coleta), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Exclui um coleta")
    public ResponseEntity<ResponseBodyDTO<ColetaModel>> inactiveColeta(@PathVariable("id") Long id){
        String usuario = "sistema";
        logger.info(" Coleta id " + id + " excluido pelo usuário " + usuario);
        return  buildResponseBody(coletaService.inactiveColeta(id), HttpStatus.OK);
    }
}
