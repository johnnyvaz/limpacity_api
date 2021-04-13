package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.PostoColetaDTO;
import br.com.limpacity.api.model.PostoColetaModel;
import br.com.limpacity.api.service.PostoColetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Tag(name = "PostoColetaController", description = "Cadastra os tipos de postocoleta ou resíduos recicláveis")
@RequestMapping(value = "/api/v1/postocoleta")
public class PostoColetaController extends BaseController {

    private final Logger logger = Logger.getLogger(PostoColetaController.class);

    @Autowired
    private final PostoColetaService postoColetaService;

    @PostMapping
    @Operation(description = "Insere um novo postocoleta reciclável")
    public ResponseEntity<ResponseBodyDTO<PostoColetaModel>> postPostoColeta(@Valid @RequestBody PostoColetaDTO postocoleta) {
        return buildResponseBody(postoColetaService.create(postocoleta), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Busca os postos de coleta cadastrados")
    public ResponseEntity<ResponseBodyDTO<PostoColetaModel>> findAll() throws Exception {
        return buildResponseBody(postoColetaService.findAllAndActive(), HttpStatus.OK);
    }

    @GetMapping(value = "/tudo")
    @Operation(description = "Busca os postos de coleta cadastrados")
    public ResponseEntity<ResponseBodyDTO<PostoColetaModel>> findTudo() throws Exception {
        return buildResponseBody(postoColetaService.findTudo(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(description = "Busca um postocoleta cadastrado")
    public ResponseEntity<ResponseBodyDTO<PostoColetaModel>> findByName(@PathVariable("id") Long id) {
        return buildResponseBody(postoColetaService.findByIdAndActive(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(description = "Altera um postocoleta")
    public ResponseEntity<ResponseBodyDTO<PostoColetaModel>> updatePostoColeta(@PathVariable("id") Long id,
                                      @RequestBody PostoColetaDTO postocoleta){
        return buildResponseBody(postoColetaService.updatePostoColeta(id, postocoleta), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Exclui um postocoleta")
    public ResponseEntity<ResponseBodyDTO<PostoColetaModel>> inactivePostoColeta(@PathVariable("id") Long id){
        String usuario = "sistema";
        logger.info(" PostoColeta id " + id + " excluido pelo usuário " + usuario);
        return  buildResponseBody(postoColetaService.inactivePostoColeta(id), HttpStatus.OK);
    }
}
