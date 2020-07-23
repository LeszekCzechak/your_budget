package com.czechak.leszek.your_budget.model.account;

import com.czechak.leszek.your_budget.dto.Account;
import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlAccountRepository extends AccountRepository, JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAccountEntitiesByUserEntity(UserEntity userEntity);

//    @Query("select account from AccountEntity account where account.userEntity.userId = :userId")
//    List<AccountEntity> findAccountsForUser(@Param("userId") Long userId);

}
