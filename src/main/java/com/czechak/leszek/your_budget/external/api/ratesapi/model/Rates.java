package com.czechak.leszek.your_budget.external.api.ratesapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Rates {

    @JsonAlias({"USD","GBP","HKD","IDR","PHP","LVL","INR","CHF","MXN","SGD","CZK","THB","BGN","EUR","MYR","NOK","CNY","HRK","PLN","LTL","TRY","ZAR","CAD","BRL","RON","DKK","NZD","EEK","JPY","RUB","KRW","USD","AUD","HUF","SEK"})
    BigDecimal amount;


}
