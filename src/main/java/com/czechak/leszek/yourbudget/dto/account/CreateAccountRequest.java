package com.czechak.leszek.yourbudget.dto.account;

import com.czechak.leszek.yourbudget.model.Currency;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateAccountRequest {

    @NotBlank(message = "This field must not be empty")
    private String description;
    private Currency currency;

}
