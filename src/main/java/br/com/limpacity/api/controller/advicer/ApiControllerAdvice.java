package br.com.limpacity.api.controller.advicer;

import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.controller.base.error.ErrorCodeEnum;
import br.com.limpacity.api.controller.base.error.ErrorDTO;
import br.com.limpacity.api.controller.base.error.ErrorDTOFactory;
import br.com.limpacity.api.exception.EstacaoNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;


@SuppressWarnings("rawtypes")
@Slf4j
@ControllerAdvice
public class ApiControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler({HibernateException.class})
    public ResponseEntity handleHibernateException(HibernateException ex) {

        log.error("Hibernate {} " , ex.getMessage());
        ErrorDTO errorDto = ErrorDTOFactory.getInternalServerError(ex.getMessage())	;
        return ResponseEntity.status(Objects.requireNonNull(
                ErrorCodeEnum.findHttpStatus(errorDto.getErrorCode())))
                .body(ResponseBodyDTO.with(errorDto));
    }

    @ExceptionHandler({EstacaoNotFoundException.class})
    public ResponseEntity handleIdNotFoundException(RuntimeException ex) {
        return buildResponseNotFound(ex.getMessage());
    }

    private ResponseEntity<?> buildResponseNotFound(String info) {
        return ResponseEntity.status(ErrorCodeEnum.NOT_FOUND.getHttpCode())
                .body(ErrorDTOFactory.getNotFound(info));
    }

}