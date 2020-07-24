package com.czechak.leszek.your_budget.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentOnAccountRequest {

    private Long targetAccountId;
    private BigDecimal amount;
    private String description;

}
