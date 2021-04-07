package br.com.limpacity.api.controller;

import br.com.limpacity.api.controller.base.BaseController;
import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.dto.EstacaoDTO;
import br.com.limpacity.api.model.EstacaoModel;
import br.com.limpacity.api.model.MunicipioModel;
import br.com.limpacity.api.service.EnderecoService;
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
@Tag(name = "EnderecoController", description = "Consulta dados relacionados a endereços, se estão liberados para uso so sistema")
@RequestMapping(value = "/api/v1/endereco")
public class EnderecoController extends BaseController {

    private final Logger logger = Logger.getLogger(EnderecoController.class);

    @Autowired
    private final EnderecoService enderecoService;

    @GetMapping("/municipios")
    @Operation(description = "Busca de municípios habilitados para uso do sistema")
    public ResponseEntity<ResponseBodyDTO<MunicipioModel>> findAll() throws Exception {
        return buildResponseBody(enderecoService.findAllMunicipio(), HttpStatus.OK);
    }

    @GetMapping("/codmunicipio/{codigo}")
    @Operation(description = "Busca uma cidade pelo código e retorna true ou False se está habilitada para uso do sistema")
    public ResponseEntity<ResponseBodyDTO> findByCodigo(@PathVariable("codigo") Long codigo) {
        return buildResponseBody(enderecoService.findByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping("/nomemunicipio/{nome}")
    @Operation(description = "Busca uma cidade pelo nome e retorna true ou False se está habilitada para uso do sistema")
    public ResponseEntity<ResponseBodyDTO> findByNome(@PathVariable("nome") String nome) {
        return buildResponseBody(enderecoService.findByNome(nome), HttpStatus.OK);
    }
//
//    @PutMapping("{id}")
//    @Operation(description = "Altera um estacao")
//    public ResponseEntity<ResponseBodyDTO<EstacaoModel>> updateEstacao(@PathVariable("id") Long id,
//                                      @RequestBody EstacaoDTO estacao){
//        return buildResponseBody(estacaoService.updateEstacao(id, estacao), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("{id}")
//    @Operation(description = "Exclui um estacao")
//    public ResponseEntity<ResponseBodyDTO<EstacaoModel>> inactiveEstacao(@PathVariable("id") Long id){
//        String usuario = "sistema";
//        logger.info(" Estacao id " + id + " excluido pelo usuário " + usuario);
//        return  buildResponseBody(estacaoService.inactiveEstacao(id), HttpStatus.OK);
//    }
}
