package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.currency.CurrencyResponse;
import com.czechak.leszek.your_budget.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class CurrencyController {

    CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency")
    public ResponseEntity<CurrencyResponse> getAllCurrencys(){
    //TODO ogarnąć tą metodę
        return  ResponseEntity.ok((CurrencyResponse) null);
    }

}
