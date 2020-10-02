package com.czechak.leszek.yourbudget.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(basePackage("com.czechak.leszek.yourbudget.controller"))
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .apiInfo(apiInfo())
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MY BUDGET API",
                "Plan your budget",
                "0.1",
                null,
                new Contact("Leszek Czechak", null, "leszek.czechak@gmail.com"),
              null,
                null,
                Collections.EMPTY_LIST
        );
    }
}
