package com.czechak.leszek.yourbudget.dto.purpose;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpendOnPurposeRequest {

    private Long sourceAccountId;
    private Long targetAccountId;
    private BigDecimal amount;
    private String description;


}
