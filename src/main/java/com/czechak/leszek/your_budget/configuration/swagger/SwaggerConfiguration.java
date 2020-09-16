package com.czechak.leszek.your_budget.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(basePackage("com.czechak.leszek.your_budget.controller"))
                .build()
                .pathMapping("/");
    }

}
