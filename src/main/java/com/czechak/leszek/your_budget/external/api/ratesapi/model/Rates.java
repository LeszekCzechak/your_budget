package com.czechak.leszek.your_budget.external.api.ratesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Rates {

    @JsonProperty("GBP")
    BigDecimal gbpRate;
    @JsonProperty("HKD")
    BigDecimal hkdRate;
    @JsonProperty("IDR")
    BigDecimal idrRate;
    @JsonProperty("ILS")
    BigDecimal ilsRate;
    @JsonProperty("DKK")
    BigDecimal dkkRate;
    @JsonProperty("INR")
    BigDecimal inrRate;
    @JsonProperty("CHF")
    BigDecimal chfRate;
    @JsonProperty("MXN")
    BigDecimal mxnRate;
    @JsonProperty("CZK")
    BigDecimal czkRate;
    @JsonProperty("SGD")
    BigDecimal sgdRate;
    @JsonProperty("THB")
    BigDecimal thbRate;
    @JsonProperty("HRK")
    BigDecimal hrkRate;
    @JsonProperty("MYR")
    BigDecimal myrRate;
    @JsonProperty("NOK")
    BigDecimal nokRate;
    @JsonProperty("CNY")
    BigDecimal cnyRate;
    @JsonProperty("BGN")
    BigDecimal bgnRate;
    @JsonProperty("PHP")
    BigDecimal phpRate;
    @JsonProperty("SEK")
    BigDecimal sekRate;
    @JsonProperty("PLN")
    BigDecimal plnRate;
    @JsonProperty("ZAR")
    BigDecimal zarRate;
    @JsonProperty("CAD")
    BigDecimal cadRate;
    @JsonProperty("ISK")
    BigDecimal iskRate;
    @JsonProperty("BRL")
    BigDecimal brlRate;
    @JsonProperty("RON")
    BigDecimal ronRate;
    @JsonProperty("NZD")
    BigDecimal nzdRate;
    @JsonProperty("TRY")
    BigDecimal tryRate;
    @JsonProperty("JPY")
    BigDecimal jpyRate;
    @JsonProperty("RUB")
    BigDecimal rubRate;
    @JsonProperty("KRW")
    BigDecimal krwRate;
    @JsonProperty("USD")
    BigDecimal usdRate;
    @JsonProperty("HUF")
    BigDecimal hufRate;
    @JsonProperty("AUD")
    BigDecimal audRate;
}
