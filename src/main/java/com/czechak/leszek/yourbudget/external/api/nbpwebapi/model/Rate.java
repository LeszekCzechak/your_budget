package com.czechak.leszek.yourbudget.external.api.nbpwebapi.model;

import com.czechak.leszek.yourbudget.model.Currency;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class Rate {

    private String currency;

    private Currency code;

    private BigDecimal mid;
}
