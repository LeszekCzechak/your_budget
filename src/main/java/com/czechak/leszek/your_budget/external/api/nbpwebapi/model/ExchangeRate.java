package com.czechak.leszek.your_budget.external.api.nbpwebapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExchangeRate {

    @JsonProperty("table")
    private String table;

    @JsonProperty("no")
    private String number;

    @JsonProperty("effectiveDate")
    private String effectiveDate;

    @JsonProperty("rates")
    private List<Rate> rates;

}
