package com.czechak.leszek.your_budget.dto;

import lombok.Data;


@Data
public class EditUserRequest {

    private String login;
    private String mail;
    private String userName;

}
