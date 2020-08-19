package com.czechak.leszek.your_budget.dto.account;

import com.czechak.leszek.your_budget.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long accountId;
    private Long userId;
    private String description;
    private BigDecimal amount;
    private LocalDateTime cratedOn;
    private LocalDateTime updatedOn;
    private Currency currency;


}
