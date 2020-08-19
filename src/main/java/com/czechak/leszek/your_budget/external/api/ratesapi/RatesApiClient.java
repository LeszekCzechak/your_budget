package com.czechak.leszek.your_budget.external.api.ratesapi;

import com.czechak.leszek.your_budget.external.api.ratesapi.model.CurrencyExchangeResponse;
import com.czechak.leszek.your_budget.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;

@Component
public class RatesApiClient {

    private final WebClient webClient;

    public RatesApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public CurrencyExchangeResponse currencyExchange(Currency sourceCurrency
            , Currency targetCurrency
            , LocalDate date) {

        String apiUrl = "/" + date + "?base=" + targetCurrency + "&symbols=" + sourceCurrency;

        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(CurrencyExchangeResponse.class)
                .block();

    }
}
