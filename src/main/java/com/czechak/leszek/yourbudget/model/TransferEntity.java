package com.czechak.leszek.yourbudget.model;

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
    //TODO dodać tu pole waluty source z której się przelewa hajsy
//    private Currency currency;
    private LocalDateTime transferData;
    private String description;

}
