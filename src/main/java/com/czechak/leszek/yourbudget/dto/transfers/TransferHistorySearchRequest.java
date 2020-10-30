package com.czechak.leszek.yourbudget.dto.transfers;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class TransferHistorySearchRequest {

    private Set<Long> accountIdsFrom;
    private LocalDate transferBefore;
    private LocalDate transferAfter;
    private BigDecimal amountFrom;
    private BigDecimal amountTo;
    private String query;


}
