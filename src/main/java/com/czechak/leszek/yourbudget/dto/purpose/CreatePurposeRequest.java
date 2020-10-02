package com.czechak.leszek.yourbudget.dto.purpose;


import com.czechak.leszek.yourbudget.model.Currency;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreatePurposeRequest {

    @NotBlank(message = "This field must not be empty")
    private String description;
    private Long categoryId;
    private Currency currency;

}
