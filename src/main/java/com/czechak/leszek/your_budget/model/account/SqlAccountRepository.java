package com.czechak.leszek.your_budget.model.account;

import com.czechak.leszek.your_budget.repository.AccountEntity;
import com.czechak.leszek.your_budget.repository.PurposeEntity;
import com.czechak.leszek.your_budget.repository.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlAccountRepository extends AccountRepository, JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findAccountEntitiesByUserEntity(UserEntity userEntity);

}
