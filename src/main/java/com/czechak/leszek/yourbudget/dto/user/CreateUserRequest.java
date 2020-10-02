package com.czechak.leszek.yourbudget.dto.user;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateUserRequest {

    @NotBlank(message = "This field must not be empty")
    @Min(value = 3, message = "Login should not be less than 3")
    private String login;
    @NotBlank(message = "This field must not be empty")
    private String password;
}
