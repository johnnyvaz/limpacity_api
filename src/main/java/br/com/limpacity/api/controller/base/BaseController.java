package br.com.limpacity.api.controller.base;

import br.com.limpacity.api.controller.base.error.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class BaseController {

    protected <T> ResponseEntity< ResponseBodyDTO<T> > buildSuccessPost(T record ) {
        return 	buildSuccessResponse(record, HttpStatus.CREATED) ;
    }

    protected <T> ResponseEntity< ResponseBodyDTO<T> > buildSuccessResponse(T record ,HttpStatus httpStatus) {
        return 	ResponseEntity.status(httpStatus).body(ResponseBodyDTO.of(record)) ;

    }

    protected <T> ResponseEntity< ResponseBodyDTO<T> > buildResponse(ResponseBodyDTO<T> responseBody, HttpStatus httpStatusSuccess) {
        return responseBody.isSucess() ?
                ResponseEntity.status(httpStatusSuccess).body(responseBody) :
                errorResponse(responseBody);
    }

    protected <T> ResponseEntity< ResponseBodyDTO<T> > errorResponse(ResponseBodyDTO<T> responseBody) {
        return 	ResponseEntity
                .status(ErrorCodeEnum.findHttpStatus(responseBody.getErrors().get(0).getErrorCode())).body(responseBody);
    }

    protected <T> ResponseEntity buildPostResponseBody(T body) {
        return buildResponse(ResponseBodyDTO.of(body), HttpStatus.CREATED);
    }

    protected <T> ResponseEntity buildResponseBody(T body, HttpStatus httpStatus) {
        return buildResponse(ResponseBodyDTO.of(body), httpStatus);
    }

    protected <T> ResponseEntity buildResponseBody(List<T> body, HttpStatus httpStatus) {
        return buildResponse(ResponseBodyDTO.of(body), httpStatus);
    }

}
