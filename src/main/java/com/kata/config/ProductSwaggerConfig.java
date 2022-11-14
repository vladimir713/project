package com.kata.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductSwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Product Swagger Api")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("vladimir713@mail.ru.ru")
                                                .name("Vladimir Chugunov")
                                )
                );
    }
}
