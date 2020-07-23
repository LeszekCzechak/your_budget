package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.model.user.UserRepository;
import com.czechak.leszek.your_budget.repository.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserContext {


    UserRepository userRepository;

    @Autowired
    public UserContext(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getCurrentUser() {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(1L);
        UserEntity userEntity = optionalUserEntity.get();
        return userEntity;
    }
}
