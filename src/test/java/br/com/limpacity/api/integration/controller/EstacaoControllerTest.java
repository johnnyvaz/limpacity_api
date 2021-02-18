package br.com.limpacity.api.integration.controller;

import br.com.limpacity.api.controller.EstacaoController;
import br.com.limpacity.api.controller.advicer.ApiControllerAdvice;
import br.com.limpacity.api.integration.config.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;


@IntegrationTest
class EstacaoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private EstacaoController estacaoController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(estacaoController)
                .setControllerAdvice(new ApiControllerAdvice()).build();
        initMocks(this);
    }

    @Test
    void shouldInjectDependencies() {
        assertNotNull(this.mockMvc);
        assertNotNull(this.estacaoController);
    }


}
