package org.kdp.learn_vocabulary_kdp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.kdp.learn_vocabulary_kdp.controller.v1")
public class OpenApiConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Kiet Hoang");
        myContact.setEmail("kiethoang101.dev@gmail.com");
        myContact.setUrl("https://github.com/K1ethoang");

        Info information = new Info().title("Learn Vocabulary KDP System API").version("1.0").description("API documentation for website learn English vocabulary").contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
