package com.czechak.leszek.your_budget.external.api.ratesapi.model;

import com.czechak.leszek.your_budget.model.Currency;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CurrencyExchangeResponse {

    Currency base;
    Rates rates;
    LocalDate date;

}
