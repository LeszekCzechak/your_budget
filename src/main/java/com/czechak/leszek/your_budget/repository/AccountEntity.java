package com.czechak.leszek.your_budget.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    private UserEntity userEntity;
    private String description;
    private BigDecimal amount;
    private LocalDateTime cratedOn;
    private LocalDateTime updatedOn;
    private Boolean active;


}
