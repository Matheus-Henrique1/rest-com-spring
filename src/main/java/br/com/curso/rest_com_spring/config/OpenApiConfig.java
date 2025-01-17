package br.com.curso.rest_com_spring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Curso rest com spring")
                        .version("v1")
                        .description("Some description about API")
                        .termsOfService("https://curso-rest-spring.com.br")
                        .license(new License().name("Apache 2.0")
                                .url("https://curso-rest-spring.com.br")));
    }

}
