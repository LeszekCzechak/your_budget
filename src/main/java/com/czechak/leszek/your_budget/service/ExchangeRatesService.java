package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.external.api.nbpwebapi.NBPApiClient;
import com.czechak.leszek.your_budget.external.api.nbpwebapi.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExchangeRatesService {

    private final NBPApiClient nbpApiClient;

    @Autowired
    public ExchangeRatesService(NBPApiClient nbpApiClient) {
        this.nbpApiClient = nbpApiClient;
    }


    public Collection<ExchangeRate> getExchanges() {
        //normalnie tutaj przepakowanie na docelowy typ danych
        return nbpApiClient.getExchangeRates();
    }
}
