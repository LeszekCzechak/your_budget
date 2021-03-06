package com.czechak.leszek.yourbudget.dto.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferFromAccountRequest {

    private Long userId;
    private Long selectedAccountId;
    private Long targetAccountId;
    private BigDecimal amount;
    private String description;


}
