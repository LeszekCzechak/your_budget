package com.czechak.leszek.your_budget.external.api.nbpwebapi.model;

import com.czechak.leszek.your_budget.model.Currency;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class Rate {

    private String currency;

    private Currency code;

    private BigDecimal mid;
}
