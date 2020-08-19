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

import java.time.LocalDate;

@Component
public class RatesApiClient {

    private final String BASE_API = "https://api.ratesapi.io/api";
    private final RestTemplate restTemplate;

    @Autowired
    public RatesApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CurrencyExchangeResponse currencyExchange(Currency sourceCurrency
            , Currency targetCurrency
            , LocalDate date) {

        String apiUrl = BASE_API + "/" + date + "?base=" + targetCurrency + "&symbols=" + sourceCurrency;

        HttpHeaders httpHeaders= new HttpHeaders();

        ResponseEntity<CurrencyExchangeResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                new ParameterizedTypeReference<CurrencyExchangeResponse>(){}
        );

        System.out.println(response.toString());

        return response.getBody();
    }

}
