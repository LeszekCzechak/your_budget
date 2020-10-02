package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.external.api.ratesapi.RatesApiClient;
import com.czechak.leszek.yourbudget.external.api.ratesapi.model.CurrencyExchangeResponse;
import com.czechak.leszek.yourbudget.external.api.ratesapi.model.Rates;
import com.czechak.leszek.yourbudget.model.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyExchangeServiceTest {

    @Mock
    RatesApiClient ratesApiClient;

    CurrencyExchangeService currencyExchangeService;

    @BeforeEach
    void setUp() {
        currencyExchangeService = new CurrencyExchangeService(ratesApiClient);
    }

    @Test
    void shouldReturnExchangeCurrencyDuringTransfer() {

        //given
        CurrencyExchangeResponse currencyExchangeResponse = new CurrencyExchangeResponse();
        currencyExchangeResponse.setBase(Currency.PLN);
        currencyExchangeResponse.setDate(LocalDate.MIN);
        currencyExchangeResponse.setRates(new Rates(BigDecimal.valueOf(2)));

        when(ratesApiClient.currencyExchange(Currency.PLN, Currency.EUR, LocalDate.now())).thenReturn(currencyExchangeResponse);
        //when
        BigDecimal response = currencyExchangeService.exchangeCurrencyDuringTransfer(Currency.EUR, Currency.PLN, BigDecimal.TEN);

        //then
        assertEquals(BigDecimal.valueOf(20), response);


    }
}