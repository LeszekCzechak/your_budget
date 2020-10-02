package com.czechak.leszek.yourbudget.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;

}
