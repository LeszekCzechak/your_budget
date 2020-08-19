package com.czechak.leszek.your_budget.repository.account;

import com.czechak.leszek.your_budget.model.AccountEntity;
import com.czechak.leszek.your_budget.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Optional<AccountEntity> findById(Long id);

    AccountEntity save(AccountEntity accountEntity);

    List<AccountEntity> findAccountEntitiesByUserEntity(UserEntity userEntity);

}
