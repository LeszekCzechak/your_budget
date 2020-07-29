package com.czechak.leszek.your_budget.dto.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetUserResponse {

    private String login;
    private String password;
    private String mail;
    private String userName;
    private LocalDateTime createUserDate;
    private LocalDateTime updatedOn;

}
