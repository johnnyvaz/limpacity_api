package br.com.limpacity.api.controller.advicer;

import br.com.limpacity.api.controller.base.ResponseBodyDTO;
import br.com.limpacity.api.controller.base.error.ErrorCodeEnum;
import br.com.limpacity.api.controller.base.error.ErrorDTO;
import br.com.limpacity.api.controller.base.error.ErrorDTOFactory;
import br.com.limpacity.api.controller.base.handle.HandleValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public abstract class BaseControllerAdvice {
    private static Logger log = LoggerFactory.getLogger(BaseControllerAdvice.class);

    public BaseControllerAdvice() {
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception ex, WebRequest request) {
        return ResponseEntity.status(ErrorCodeEnum.findHttpStatus(ErrorDTOFactory.getInternalServerError(ex.getMessage()).getErrorCode())).body(ResponseBodyDTO.with(ErrorDTOFactory.getInternalServerError(ex.getMessage() == null ? ex.getClass().getName() : ex.getMessage())));
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        ErrorDTO errorDTO = ErrorDTOFactory.getMissingParameter("value", ex.getParameterName());
        HttpStatus httpStatus = ErrorCodeEnum.findHttpStatus(errorDTO.getErrorCode());

        assert httpStatus != null;

        return ResponseEntity.status(httpStatus).body(ResponseBodyDTO.with(errorDTO));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity handleApiException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        HandleValidationError handleValidationError = new HandleValidationError();
        List<ErrorDTO> errors = handleValidationError.createErrorsFromList(fieldErrors);
        int HTTPCode = ErrorCodeEnum.MALFORMED_REQUEST_BODY.getHttpCode().value();
        return ResponseEntity.status(HTTPCode).body(ResponseBodyDTO.with(errors));
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity handleApiException(HttpMessageNotReadableException ex) {
        ErrorDTO errorDto = ErrorDTOFactory.getMalformedRequestBody(ex.getMessage());
        HttpStatus httpStatus = ErrorCodeEnum.findHttpStatus(errorDto.getErrorCode());

        assert httpStatus != null;

        return ResponseEntity.status(httpStatus).body(ResponseBodyDTO.with(errorDto));
    }
}

