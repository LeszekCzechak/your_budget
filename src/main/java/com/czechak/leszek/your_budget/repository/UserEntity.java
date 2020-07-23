package com.czechak.leszek.your_budget.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "This field must not be empty")
    private String login;
    @NotBlank(message = "This field must not be empty")
    private String password;
    @Email
    private String mail;
    private String userName;
    private LocalDateTime createUserDate;
    @OneToMany
    private List<AccountEntity> accountEntities;

}
