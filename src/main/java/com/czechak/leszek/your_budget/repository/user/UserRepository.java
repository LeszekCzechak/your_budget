package com.czechak.leszek.your_budget.repository.user;

import com.czechak.leszek.your_budget.model.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity userEntity);
}
