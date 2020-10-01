package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.repository.user.UserRepository;
import com.czechak.leszek.your_budget.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserContext {


    private UserRepository userRepository;

    public UserEntity getCurrentUser() {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(1L);
        UserEntity userEntity = optionalUserEntity.get();
        return userEntity;
    }
}
