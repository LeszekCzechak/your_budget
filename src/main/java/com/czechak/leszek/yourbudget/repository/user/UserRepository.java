package com.czechak.leszek.yourbudget.repository.user;

import com.czechak.leszek.yourbudget.model.UserEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity userEntity);

    Optional<UserDetails> loadUserByUsername(@Param("username") String username);
}
