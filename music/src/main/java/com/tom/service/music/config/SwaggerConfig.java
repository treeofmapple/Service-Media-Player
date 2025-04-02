package com.tom.service.music.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class SwaggerConfig {
	
	@Value("server.port")
	private String port;

	@Bean
	OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Url Shortener")
                .description("Encurtador de Urls")
                .version("v1.11a")
                .contact(new Contact().name("Samuel").url("https://"))
            )
            .servers(List.of(
                new Server().url("http://localhost:" + port).description("Servidor de Desenvolvimento"),
                new Server().url("http://localhost:8005").description("Servidor de Produção")
            ));
    }
	
	/*
    
    @Bean
    GroupedOpenApi usuarioApi() {
        return GroupedOpenApi.builder()
                .group("1 - Usuario")
                .pathsToMatch("/**") 
                .pathsToExclude("/api/v1/dev/**")
                .build();
    }
    
    @Bean
    GroupedOpenApi developmentAPI() {
        return GroupedOpenApi.builder()
                .group("2 - Development API")
                .pathsToMatch("/**")
                .build();
    }
    
    */
}