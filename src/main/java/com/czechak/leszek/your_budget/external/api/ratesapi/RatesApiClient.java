package com.czechak.leszek.your_budget.external.api.ratesapi;

import com.czechak.leszek.your_budget.external.api.ratesapi.model.CurrencyExchangeResponse;
import com.czechak.leszek.your_budget.model.Currency;
import org.springframework.stereotype.Component;
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
