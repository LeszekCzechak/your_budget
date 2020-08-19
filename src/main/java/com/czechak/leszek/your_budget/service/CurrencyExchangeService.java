package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.external.api.ratesapi.RatesApiClient;
import com.czechak.leszek.your_budget.external.api.ratesapi.model.CurrencyExchangeResponse;
import com.czechak.leszek.your_budget.model.Currency;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CurrencyExchangeService {

    private final RatesApiClient ratesApiClient;

    public CurrencyExchangeService(RatesApiClient ratesApiClient) {
        this.ratesApiClient = ratesApiClient;
    }

    public BigDecimal exchangeCurrencyDuringTransfer(Currency source, Currency target, BigDecimal amountToTransfer) {

        CurrencyExchangeResponse currencyExchangeResponse = ratesApiClient.currencyExchange( target, source, LocalDate.now());

        //TODO poniżej .getUsdRate() powinno się zmienić .getPlnRate() jeśli konwertujemy na PLN
        BigDecimal response= (currencyExchangeResponse.getRates().getUsdRate()).multiply(amountToTransfer);

        return response;
    }
}
