package br.com.limpacity.api.integration.controller;

import br.com.limpacity.api.controller.EstacaoController;
import br.com.limpacity.api.controller.advicer.ApiControllerAdvice;
import br.com.limpacity.api.integration.config.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@IntegrationTest
class EstacaoControllerTest {

    private static final String BASE_PATH = EstacaoController.API_ESTACAO;

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

    @Test
    @Sql(value = "classpath:sql/estacao.sql")
    void requestEstacaoReturn200() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.errors").doesNotExist())
                .andExpect(jsonPath("$.records").exists())
                .andExpect(jsonPath("$.records[*]").isNotEmpty())
                .andExpect(jsonPath("$.meta.recordCount").isNumber())
                .andExpect(jsonPath("$.records").isArray())
                .andExpect(jsonPath("$.records[0].id").value(1))
                .andExpect(jsonPath("$.records[0].orderType.description").value("Solto / Não Embala"))
                .andExpect(jsonPath("$.records[0].orderType.id").value(1))
                .andExpect(jsonPath("$.records[0].orderType.tied").value(false));
    }

}
