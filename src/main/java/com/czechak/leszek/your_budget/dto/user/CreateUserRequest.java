package com.czechak.leszek.your_budget.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUserRequest {

    @NotBlank(message = "This field must not be empty")
    private String login;
    @NotBlank(message = "This field must not be empty")
    private String password;
}
