package com.czechak.leszek.yourbudget.repository.account;

import com.czechak.leszek.yourbudget.model.AccountEntity;
import com.czechak.leszek.yourbudget.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Optional<AccountEntity> findById(Long id);

    AccountEntity save(AccountEntity accountEntity);

    List<AccountEntity> findAccountEntitiesByUserEntity(UserEntity userEntity);

}
