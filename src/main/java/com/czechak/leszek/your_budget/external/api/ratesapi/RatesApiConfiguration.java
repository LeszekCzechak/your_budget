package com.czechak.leszek.your_budget.external.api.ratesapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RatesApiConfiguration {

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("https://api.ratesapi.io/api")
                .build();
    }
}
