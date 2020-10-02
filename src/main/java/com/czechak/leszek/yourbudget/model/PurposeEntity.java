package com.czechak.leszek.yourbudget.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PurposeEntity extends AccountEntity {

    @OneToOne
    CategoryEntity category;

}
