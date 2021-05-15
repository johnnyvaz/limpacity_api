package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.ColetaQrcodeDTO;
import br.com.limpacity.api.service.ColetaQrcodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Tag(name = "ColetaQrcodeController", description = " Repositório das coletas solicitadas")
@RequestMapping(value = "/api/v1")
public class ColetaQrcodeController extends BaseController {

    private final Logger logger = Logger.getLogger(ColetaQrcodeController.class);

    @Autowired
    private final ColetaQrcodeService service;

    @PostMapping("/qrcode/{posto}")
    @Operation(description = "Insere uma nova solicitação de coleta vindo da leitura do QRCode ")
    public ResponseEntity<ResponseBodyDTO<ColetaQrcodeDTO>> postColetaQrcode(
            @Valid @RequestBody ColetaQrcodeDTO coleta,
            @PathVariable("posto") Long posto_id){
        logger.info("Solicitação Qrcode : Posto {} " + posto_id );
        return buildResponseBody(service.createQrcode(posto_id, coleta), HttpStatus.CREATED);
    }

    @PostMapping("/aceite/{uuid}")
    @Operation(description = "Insere o UUID com uma resposta do aceite")
    public ResponseEntity<ResponseBodyDTO<ColetaQrcodeDTO>> aceiteColeta(
            @Valid @RequestBody ColetaQrcodeDTO coleta,
            @PathVariable("posto") Long posto_id){
        logger.info("Solicitação Qrcode : Posto {} " + posto_id );
        return buildResponseBody(service.createQrcode(posto_id, coleta), HttpStatus.CREATED);
    }

//    @GetMapping("/coletar/{uuid}")
//    @Operation(description = "Insere uma nova solicitação de coleta vindo da leitura do QRCode ")
//    public ResponseEntity<ResponseBodyDTO<ColetaQrcodeDTO>> aceiteColeta(
//            @Valid @RequestBody ColetaQrcodeDTO coleta,
//            @PathVariable("posto") Long posto_id){
//        logger.info("Solicitação Qrcode : Posto {} " + posto_id );
//        return buildResponseBody(service.createQrcode(posto_id, coleta), HttpStatus.CREATED);
//    }
}
