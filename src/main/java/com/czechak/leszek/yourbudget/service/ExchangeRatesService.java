package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.external.api.nbpwebapi.NBPApiClient;
import com.czechak.leszek.yourbudget.external.api.nbpwebapi.model.ExchangeRate;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ExchangeRatesService {

    private final NBPApiClient nbpApiClient;

    public ExchangeRatesService(NBPApiClient nbpApiClient) {
        this.nbpApiClient = nbpApiClient;
    }


    public Collection<ExchangeRate> getExchanges() {
        //TODO przepakowanie na docelowy typ danych
        return nbpApiClient.getExchangeRates();
    }
}
