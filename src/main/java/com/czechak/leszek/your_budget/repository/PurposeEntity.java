package com.czechak.leszek.your_budget.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PurposeEntity extends AccountEntity {

    @OneToOne
    private CategoryEntity category;

}
