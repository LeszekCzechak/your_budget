package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.external.api.nbpwebapi.NBPApiClient;
import com.czechak.leszek.your_budget.external.api.nbpwebapi.model.ExchangeRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeRatesServiceTest {

    @Mock
    private NBPApiClient nbpApiClient;

    ExchangeRatesService exchangeRatesService;

    @BeforeEach
    void setUp() {
        exchangeRatesService = new ExchangeRatesService(nbpApiClient);
    }

    @Test
    void shouldReturnCollectionOfExchangeRate() {

        //given
        Collection<ExchangeRate> exchangeRates = new LinkedList<>();
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setEffectiveDate("date");
        exchangeRate.setNumber("number");
        exchangeRate.setTable("table");
        exchangeRate.setRates(new LinkedList<>());

        exchangeRates.add(exchangeRate);

        when(nbpApiClient.getExchangeRates()).thenReturn(exchangeRates);

        //when
        Collection<ExchangeRate> response = exchangeRatesService.getExchanges();

        //then
        assertEquals(1,response.size());
        assertEquals("date",response.stream().findFirst().get().getEffectiveDate());
        assertEquals("number",response.stream().findFirst().get().getNumber());
        assertEquals("table",response.stream().findFirst().get().getTable());
        assertEquals(0,response.stream().findFirst().get().getRates().size());


    }
}