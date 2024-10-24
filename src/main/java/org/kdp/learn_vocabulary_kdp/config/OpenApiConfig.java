package org.kdp.learn_vocabulary_kdp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.kdp.learn_vocabulary_kdp.controller"})
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
            .title("API Documentation")
            .version("1.0")
            .description("API documentation for website learn English vocabulary")
            .contact(new Contact()
                .name("Kiet Hoang")
                .email("kiethoang101.dev@gmail.com")
                .url("https://github.com/K1ethoang")));
    }

    @Bean
    public Components customComponents() {
        return new Components()
                .addSecuritySchemes("basicScheme", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("basic"));
    }
}
