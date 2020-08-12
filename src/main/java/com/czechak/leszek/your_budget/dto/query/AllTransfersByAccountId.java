package com.czechak.leszek.your_budget.dto.query;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AllTransfersByAccountId {

    private Long transferId;
    private Long userId;
    private Long sourceAccountId;
    private String sourceAccountDescription;
    private Long targetAccountId;
    private String targetAccountDescription;
    private BigDecimal transferAmount;
    private LocalDateTime transferData;
    private String transferDescription;


}
