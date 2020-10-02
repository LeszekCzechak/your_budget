package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.external.api.ratesapi.RatesApiClient;
import com.czechak.leszek.yourbudget.external.api.ratesapi.model.CurrencyExchangeResponse;
import com.czechak.leszek.yourbudget.model.Currency;
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

        BigDecimal response= (currencyExchangeResponse.getRates().getAmount()).multiply(amountToTransfer);

        return response;
    }
}
