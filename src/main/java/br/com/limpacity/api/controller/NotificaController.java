package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.ColetaDTO;
import br.com.limpacity.api.model.ColetaModel;
import br.com.limpacity.api.service.NotificaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@Tag(name = "NotificaController", description = "Endpoint para marcar se uma coleta teve sua notificação realizada")
@RequestMapping(value = "/api/v1/notifica")
public class NotificaController extends BaseController {

    private final Logger logger = Logger.getLogger(NotificaController.class);

    private final NotificaService service;

    @PutMapping("/email/{uuid}")
    @Operation(description = "Marcar a notificação de Email concluída com sucesso")
    public ResponseEntity<ResponseBodyDTO<ColetaModel>> emailNotificado(@PathVariable("uuid") UUID uuid){
        return buildResponseBody(service.emailNotificado(uuid), HttpStatus.CREATED);
    }


}
