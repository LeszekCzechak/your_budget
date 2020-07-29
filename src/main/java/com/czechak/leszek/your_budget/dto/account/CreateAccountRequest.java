package com.czechak.leszek.your_budget.dto.account;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateAccountRequest {

    @NotBlank(message = "This field must not be empty")
    private String description;

}
