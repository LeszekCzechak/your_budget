package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.external.api.nbpwebapi.model.ExchangeRate;
import com.czechak.leszek.your_budget.service.ExchangeRatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExchangeRatesController {

    ExchangeRatesService exchangeRatesService;

    public ExchangeRatesController(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping("/exchangeRates")
    public ResponseEntity<Collection<ExchangeRate>> getAllExchangeRates(){
    //TODO przekonwertować wynik
        return  ResponseEntity.ok(exchangeRatesService.getExchanges());
    }



}
