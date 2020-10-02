package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.repository.user.UserRepository;
import com.czechak.leszek.yourbudget.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserContext {


    private final UserRepository userRepository;

    public UserContext(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getCurrentUser() {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(1L);
        UserEntity userEntity = optionalUserEntity.get();
        return userEntity;
    }
}
