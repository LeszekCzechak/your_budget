package com.czechak.leszek.your_budget.dto.account;

import com.czechak.leszek.your_budget.model.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentOnAccountRequest {

    private Long targetAccountId;
    private BigDecimal amount;
    private String description;
    private Currency currency;

}
