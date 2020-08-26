package com.czechak.leszek.your_budget.external.api.nbpwebapi;

import com.czechak.leszek.your_budget.external.api.nbpwebapi.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Component
public class NBPApiClient {

    private final String BASE_API_URL = "http://api.nbp.pl/api/exchangerates";
    private final String TABLE_A_ENDOINT = String.format("%s/tables/a", BASE_API_URL);
    private final RestTemplate restTemplate;

    @Autowired
    public NBPApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Collection<ExchangeRate> getExchangeRates(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<List<ExchangeRate>> response = restTemplate.exchange(
                TABLE_A_ENDOINT,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                new ParameterizedTypeReference<List<ExchangeRate>>() {
                } //ExchangeRate[].class
        );
        return response.getBody();
    }
}
