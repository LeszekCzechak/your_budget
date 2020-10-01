package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.external.api.ratesapi.RatesApiClient;
import com.czechak.leszek.your_budget.external.api.ratesapi.model.CurrencyExchangeResponse;
import com.czechak.leszek.your_budget.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CurrencyExchangeService {

    private RatesApiClient ratesApiClient;

    public BigDecimal exchangeCurrencyDuringTransfer(Currency source, Currency target, BigDecimal amountToTransfer) {

        CurrencyExchangeResponse currencyExchangeResponse = ratesApiClient.currencyExchange( target, source, LocalDate.now());

        BigDecimal response= (currencyExchangeResponse.getRates().getAmount()).multiply(amountToTransfer);

        return response;
    }
}
