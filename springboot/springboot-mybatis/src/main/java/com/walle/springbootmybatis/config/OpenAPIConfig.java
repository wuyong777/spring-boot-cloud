package com.walle.springbootmybatis.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI configOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot 3 with Swagger3")
                        .version("0.1")
                        .description("Spring Boot 3.2.2 with Swagger3"));

    }
}

