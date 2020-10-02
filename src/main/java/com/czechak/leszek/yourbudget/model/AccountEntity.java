package com.czechak.leszek.yourbudget.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    private UserEntity userEntity;
    @Column(unique = true)
    private String description;
    private BigDecimal amount;
    private LocalDateTime cratedOn;
    private LocalDateTime updatedOn;
    private Boolean active;
    private Boolean expense;
    private Currency currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(userEntity, that.userEntity) &&
                Objects.equals(description, that.description) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(cratedOn, that.cratedOn) &&
                Objects.equals(updatedOn, that.updatedOn) &&
                Objects.equals(active, that.active) &&
                Objects.equals(expense, that.expense) &&
                currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userEntity, description, amount, cratedOn, updatedOn, active, expense, currency);
    }
}
