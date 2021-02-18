package br.com.limpacity.api.integration.converter;

import br.com.limpacity.api.converter.EstacaoConverter;
import br.com.limpacity.api.integration.config.IntegrationTest;
import br.com.limpacity.api.service.impl.EstacaoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationTest
class EstacaoConverterTest {

    @Autowired
    private EstacaoConverter estacaoConverter;

    @Autowired
    private EstacaoServiceImpl estacaoService;

    @Test
    void shouldInjectDependencies(){
        assertNotNull(estacaoService);
        assertNotNull(estacaoConverter);
    }



}
