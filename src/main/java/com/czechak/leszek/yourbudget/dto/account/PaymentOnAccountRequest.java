package com.czechak.leszek.yourbudget.dto.account;

import com.czechak.leszek.yourbudget.model.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentOnAccountRequest {

    private Long targetAccountId;
    private BigDecimal amount;
    private String description;
    private Currency currency;

}
