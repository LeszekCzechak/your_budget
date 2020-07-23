package com.czechak.leszek.your_budget.repository;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transfers")
@Data
@Entity
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;
    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private AccountEntity selectedAccount;
    @ManyToOne
    private AccountEntity targetAccount;
    private BigDecimal amount;
    private LocalDateTime transferData;



}
