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
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@Tag(name = "ColetaController", description = " Repositório das coletas solicitadas")
@RequestMapping(value = "/api/v1/coleta")
public class ColetaQrcodeController extends BaseController {

    private final Logger logger = Logger.getLogger(ColetaQrcodeController.class);

    @Autowired
    private final ColetaQrcodeService service;

    @GetMapping("/qrcode/{posto}")
    @Operation(description = "Insere uma nova solicitação de coleta vindo da leitura do QRCode ")
    public ResponseEntity<ResponseBodyDTO<ColetaQrcodeModel>> postColetaQrcode(
            @PathVariable("posto") Long posto_id){
        logger.info("Solicitação Qrcode : Posto {} " + posto_id );
        return buildResponseBody(service.createQrcode(posto_id), HttpStatus.CREATED);
    }

//    @PostMapping("/qrcode/{estacao}")
//    @Operation(description = "Insere uma nova solicitação de coleta vindo da leitura do QRCode ")
//    public ResponseEntity<ResponseBodyDTO<ColetaQrcodeModel>> postColetaQrcode(
//            @PathVariable("estacao") Long estacao_id){
//        logger.info("Solicitação Qrcode : Estacao {} " + estacao_id );
//        return buildResponseBody(service.createQrcode(estacao_id), HttpStatus.OK);
//    }

}
