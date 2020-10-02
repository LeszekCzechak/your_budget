package com.czechak.leszek.yourbudget.external.api.ratesapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rates {

    @JsonAlias({"USD","GBP","HKD","IDR","PHP","LVL","INR","CHF","MXN","SGD","CZK","THB","BGN","EUR","MYR","NOK","CNY","HRK","PLN","LTL","TRY","ZAR","CAD","BRL","RON","DKK","NZD","EEK","JPY","RUB","KRW","USD","AUD","HUF","SEK"})
    BigDecimal amount;


}
