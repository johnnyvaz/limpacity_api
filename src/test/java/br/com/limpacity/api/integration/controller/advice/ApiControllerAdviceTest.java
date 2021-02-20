package br.com.limpacity.api.integration.controller.advice;

import br.com.limpacity.api.controller.advicer.ApiControllerAdvice;
import br.com.limpacity.api.exception.MaterialIdNotFoundException;
import br.com.limpacity.api.integration.config.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@IntegrationTest
class ApiControllerAdviceTest {

    @Autowired
    private ApiControllerAdvice apiControllerAdvice;

    @Test
    void shouldHandleHandleIdNotFound() {
        ResponseEntity responseEntity = apiControllerAdvice
                .handleIdNotFoundException(new MaterialIdNotFoundException(1L));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity);
    }
}
