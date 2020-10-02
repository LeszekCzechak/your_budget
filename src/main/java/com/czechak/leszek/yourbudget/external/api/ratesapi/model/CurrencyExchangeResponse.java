package com.czechak.leszek.yourbudget.external.api.ratesapi.model;

import com.czechak.leszek.yourbudget.model.Currency;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CurrencyExchangeResponse {

    Currency base;
    Rates rates;
    LocalDate date;

}
