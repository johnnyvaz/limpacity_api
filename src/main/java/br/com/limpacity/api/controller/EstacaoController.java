package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.EstacaoDTO;
import br.com.limpacity.api.model.EstacaoModel;
import br.com.limpacity.api.service.EstacaoService;
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
@Tag(name = "EstacaoController", description = "Cadastra os tipos de estacao ou resíduos recicláveis")
@RequestMapping(value = "/api/v1/estacao")
public class EstacaoController extends BaseController {

    public static final String API_ESTACAO = "/api/v1/estacao";
    private final Logger logger = Logger.getLogger(EstacaoController.class);

    @Autowired
    private final EstacaoService estacaoService;

    @PostMapping
    @Operation(description = "Insere um novo estacao reciclável")
    public ResponseEntity<ResponseBodyDTO<EstacaoModel>> postEstacao(@Valid @RequestBody EstacaoDTO estacao) {
        return buildResponseBody(estacaoService.create(estacao), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Busca os materiais cadastrados")
    public ResponseEntity<ResponseBodyDTO<EstacaoModel>> findAll() throws Exception {
        return buildResponseBody(estacaoService.findAllAndActive(), HttpStatus.OK);
    }

    @GetMapping("{descricao}")
    @Operation(description = "Busca um estacao cadastrado")
    public ResponseEntity<ResponseBodyDTO<EstacaoModel>> findByName(@PathVariable("descricao") String descricao) {
        return buildResponseBody(estacaoService.findByNameAndActive(descricao), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(description = "Altera um estacao")
    public ResponseEntity<ResponseBodyDTO<EstacaoModel>> updateEstacao(@PathVariable("id") Long id,
                                      @RequestBody EstacaoDTO estacao){
        return buildResponseBody(estacaoService.updateEstacao(id, estacao), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Exclui um estacao")
    public ResponseEntity<ResponseBodyDTO<EstacaoModel>> inactiveEstacao(@PathVariable("id") Long id){
        String usuario = "sistema";
        logger.info(" Estacao id " + id + " excluido pelo usuário " + usuario);
        return  buildResponseBody(estacaoService.inactiveEstacao(id), HttpStatus.OK);
    }
}
