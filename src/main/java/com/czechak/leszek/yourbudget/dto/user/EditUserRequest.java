package com.czechak.leszek.yourbudget.dto.user;

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
