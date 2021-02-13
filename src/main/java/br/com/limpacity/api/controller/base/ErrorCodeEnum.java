package br.com.limpacity.api.controller.base;

import org.springframework.http.HttpStatus;

public enum ErrorCodeEnum {

    MISSING_PARAMETERS(20001L, HttpStatus.BAD_REQUEST),
    UNKNOWN_PARAMETERS(20006L, HttpStatus.BAD_REQUEST),
    MISSING_REQUEST_BODY(20019L, HttpStatus.BAD_REQUEST),
    NOT_FOUND(20023L, HttpStatus.NOT_FOUND),
    CONFLICT(29999L, HttpStatus.CONFLICT),
    ALREADY_EXISTS(20033L, HttpStatus.CONFLICT),
    UNSUPPORT_OPERATION(10002L, HttpStatus.NOT_IMPLEMENTED),
    INTERNAL_SERVER_ERROR(10000L, HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_FIELD_LESSER(20005L, HttpStatus.BAD_REQUEST),
    NOT_AVAILABLE(33333L, HttpStatus.BAD_REQUEST),
    INVALID_FIELD_GREATER(20004L, HttpStatus.BAD_REQUEST),
    CONNECTION_TARGET_TIMEOUT(10005L, HttpStatus.GATEWAY_TIMEOUT),
    MALFORMED_REQUEST_BODY(20020L, HttpStatus.BAD_REQUEST),
    INVALID_DELIVERY_METHOD(20141L, HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(30001L, HttpStatus.UNAUTHORIZED);

    private Long code;

    private HttpStatus httpCode;

    ErrorCodeEnum(Long code, HttpStatus httpCode) {
        this.code = code;
        this.httpCode = httpCode;
    }

    public Long getCode() {
        return code;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }

    public static HttpStatus findHttpStatus(Long errorCode) {

        for (ErrorCodeEnum error : ErrorCodeEnum.values()) {
            if(error.getCode().equals(errorCode)) {
                return error.getHttpCode();
            }
        }

        return null;
    }

}
