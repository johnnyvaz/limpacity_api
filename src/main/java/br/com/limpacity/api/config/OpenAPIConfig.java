package br.com.limpacity.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;

@Profile("!test")
@Configuration
public class OpenAPIConfig {

    private static final String API_KEY = "bearer-key";

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new io.swagger.v3.oas.models.OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(API_KEY, apiKeySecuritySchema()))
                .info(new Info()
                        .title("Limpa City API")
                        .description("A API recebe os dados e insere no banco, e nela também existem algumas regras do " +
                        "negócio para manter a integridade dos dados. Embora a solicitação de coleta passa pela fila, " +
                        "na API também é possível inserir essas informações de forma síncrona, isso porque este sistema " +
                        "é que faz a interface com o banco de dados. ")
                        .version(appVersion))
                .security(Collections.singletonList(new SecurityRequirement().addList(API_KEY)));
    }

    public SecurityScheme apiKeySecuritySchema() {
        return
                new SecurityScheme()
                        .name("authorisation-token")
                        .description("Insira o Token sem a palavra Bearer")
                        .scheme("bearer")
                        .in(SecurityScheme.In.HEADER)
                        .bearerFormat("JWT")
                        .type(SecurityScheme.Type.HTTP);
    }
}
