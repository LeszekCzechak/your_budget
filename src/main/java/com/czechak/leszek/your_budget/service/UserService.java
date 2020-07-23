package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.CreateUserRequest;
import com.czechak.leszek.your_budget.dto.EditUserRequest;
import com.czechak.leszek.your_budget.model.user.UserRepository;
import com.czechak.leszek.your_budget.repository.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserService {

    UserRepository repository;
    UserContext userContext;

    public UserService(UserRepository repository, UserContext userContext) {
        this.repository = repository;
        this.userContext = userContext;
    }

    public void createUser (CreateUserRequest requestUser){

        UserEntity userEntity= new UserEntity();
        userEntity.setLogin(requestUser.getLogin());
        userEntity.setPassword(requestUser.getPassword());
        userEntity.setCreateUserDate(LocalDateTime.now());
        repository.save(userEntity);

    }


    public void editUser(EditUserRequest editUser) {
        UserEntity userEntity= userContext.getCurrentUser();
        userEntity.setLogin(editUser.getLogin());
        userEntity.setCreateUserDate(LocalDateTime.now());
        repository.save(userEntity);
    }
}
