/*************************************************
 * Copyright (c) 2024. K1ethoang
 * @Author: Kiet Hoang Gia
 * @LastModified: 2024/12/14 - 17:42 PM (ICT)
 ************************************************/

package org.kdp.learn_vocabulary_kdp.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Value("${server.port}")
    private String serverPort;


    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:" + serverPort);
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Kiet Hoang");
        myContact.setEmail("kiethoang101.dev@gmail.com");
        myContact.setUrl("https://github.com/K1ethoang");

        Info information = new Info().title("Learn Vocabulary KDP System API").version("1.0").description("API documentation for website learn English vocabulary").contact(myContact);

        SecurityRequirement securityRequirement = new SecurityRequirement().addList("JWT");

        Components components = new Components().addSecuritySchemes("JWT", new SecurityScheme().name("JWT").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));

        return new OpenAPI().info(information).servers(List.of(server)).addSecurityItem(securityRequirement).components(components);
    }

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder().group("V1").packagesToScan("org.kdp.learn_vocabulary_kdp.controller.v1").pathsToMatch("/api/v1/**").build();
    }
}
