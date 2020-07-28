package com.czechak.leszek.your_budget.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurposeEntity extends AccountEntity {

    private Boolean isExpensePurposeEntity = true;


}
