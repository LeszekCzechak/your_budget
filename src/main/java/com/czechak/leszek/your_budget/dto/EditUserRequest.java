package com.czechak.leszek.your_budget.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class EditUserRequest {

    @NotBlank(message = "This field must not be empty")
    private String login;
    @NotBlank(message = "This field must not be empty")
    private String mail;
    @NotBlank(message = "This field must not be empty")
    private String userName;

}
