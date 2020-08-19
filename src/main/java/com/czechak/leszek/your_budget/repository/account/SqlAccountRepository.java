package com.czechak.leszek.your_budget.repository.account;

import com.czechak.leszek.your_budget.model.AccountEntity;
import com.czechak.leszek.your_budget.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlAccountRepository extends AccountRepository, JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAccountEntitiesByUserEntity(UserEntity userEntity);

}
