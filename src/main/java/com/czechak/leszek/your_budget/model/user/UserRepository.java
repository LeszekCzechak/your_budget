package com.czechak.leszek.your_budget.model.user;

import com.czechak.leszek.your_budget.repository.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity userEntity);
}
