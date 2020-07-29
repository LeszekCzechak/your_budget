package com.czechak.leszek.your_budget.model.account;

import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.PurposeEntity;
import com.czechak.leszek.your_budget.repository.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Optional<AccountEntity> findById(Long id);

    AccountEntity save(AccountEntity accountEntity);

    List<AccountEntity> findAccountEntitiesByUserEntity(UserEntity userEntity);

    @Query("select purpose from PurposeEntity purpose where purpose.isExpensePurposeEntity == true and purpose.userEntity.userId = :userId" )
    List<PurposeEntity> findPurposesByUser(@Param("userId") Long userId);

    @Query("select purpose from PurposeEntity purpose where purpose.accountId == :accountId" )
    PurposeEntity findPurposeById(@Param("accountId") Long accountId);

}
