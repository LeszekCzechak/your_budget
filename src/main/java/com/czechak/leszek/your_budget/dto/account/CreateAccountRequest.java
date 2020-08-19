package com.czechak.leszek.your_budget.dto.account;

import com.czechak.leszek.your_budget.model.Currency;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateAccountRequest {

    @NotBlank(message = "This field must not be empty")
    private String description;
    private Currency currency;

}
