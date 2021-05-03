package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.model.ColetaQrcodeModel;
import br.com.limpacity.api.service.ColetaQrcodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "ColetaController", description = " Repositório das coletas solicitadas")
@RequestMapping(value = "/api/v1/coleta")
public class ColetaController extends BaseController {

    private final Logger logger = Logger.getLogger(ColetaController.class);

    @Autowired
    private final ColetaQrcodeService coletaQrcodeService;

//    @PostMapping
//    @Operation(description = "Insere uma nova solicitação de coleta")
//    public ResponseEntity<ResponseBodyDTO<ColetaModel>> postColeta(@Valid @RequestBody ColetaDTO coleta) {
//        return buildResponseBody(coletaService.create(coleta), HttpStatus.OK);
//    }

    @GetMapping({"uuid"})
    @Operation(description = "Busca coleta pelo código único UUID")
    public ResponseEntity<ResponseBodyDTO<ColetaQrcodeModel>> findByUuid(@PathVariable("uuid") String uuid) {
        return buildResponseBody(coletaQrcodeService.findByUuid(uuid), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Busca todas as coletas em aberto, para serem coletadas")
    public ResponseEntity<ResponseBodyDTO<ColetaQrcodeModel>> findAllColetasOpen() throws Exception {
        return buildResponseBody(coletaQrcodeService.findAllColetasOpen(), HttpStatus.OK);
    }

//    @PutMapping("{uuid}")
//    @Operation(description = "Altera um coleta")
//    public ResponseEntity<ResponseBodyDTO<ColetaModel>> updateColeta(@PathVariable("uuid") UUID uuid,
//                                      @RequestBody ColetaDTO coleta){
//        return buildResponseBody(coletaService.updateColeta(uuid, coleta), HttpStatus.CREATED);
//    }

//    @DeleteMapping("{uuid}")
//    @Operation(description = "Exclui um coleta")
//    public ResponseEntity<ResponseBodyDTO<ColetaModel>> inactiveColeta(@PathVariable("uuid") UUID uuid){
//        String usuario = "sistema";
//        logger.info(" Coleta id " + uuid + " excluido pelo usuário " + usuario);
//        return  buildResponseBody(coletaService.inactiveColeta(uuid), HttpStatus.OK);
//    }
}
