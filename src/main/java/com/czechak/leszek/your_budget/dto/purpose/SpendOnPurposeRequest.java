package com.czechak.leszek.your_budget.dto.purpose;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpendOnPurposeRequest {

    private Long sourceAccountId;
    private Long targetAccountId;
    private BigDecimal amount;
    private String description;


}
