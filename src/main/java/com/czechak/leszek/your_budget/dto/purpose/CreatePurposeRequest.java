package com.czechak.leszek.your_budget.dto.purpose;


import com.czechak.leszek.your_budget.repository.Currency;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreatePurposeRequest {

    @NotBlank(message = "This field must not be empty")
    private String description;
    private Long categoryId;
    private Currency currency;

}
