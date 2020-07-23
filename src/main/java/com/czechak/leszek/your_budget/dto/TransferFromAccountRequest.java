package com.czechak.leszek.your_budget.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferFromAccountRequest {

    private Long userId;
    private Long selectedAccountId;
    private Long targetAccountId;
    private BigDecimal amount;

}
