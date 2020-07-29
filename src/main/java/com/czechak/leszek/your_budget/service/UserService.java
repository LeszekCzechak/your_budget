package com.czechak.leszek.your_budget.service;

import com.czechak.leszek.your_budget.dto.user.CreateUserRequest;
import com.czechak.leszek.your_budget.dto.user.EditUserRequest;
import com.czechak.leszek.your_budget.dto.user.GetUserResponse;
import com.czechak.leszek.your_budget.model.user.UserRepository;
import com.czechak.leszek.your_budget.repository.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


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
        userEntity.setUpdatedOn(LocalDateTime.now());
        repository.save(userEntity);

    }


    public void editUser(EditUserRequest editUser) {
        UserEntity userEntity= userContext.getCurrentUser();
        userEntity.setLogin(editUser.getLogin());
        userEntity.setUpdatedOn(LocalDateTime.now());
        repository.save(userEntity);
    }

    public GetUserResponse getUserResponseByUserId (Long userId){

        Optional<UserEntity> optionalUserEntity = repository.findById(userId);
        UserEntity userEntity= optionalUserEntity.get();

        GetUserResponse getUserResponse= new GetUserResponse();

        getUserResponse.setLogin(userEntity.getLogin());
        getUserResponse.setPassword(userEntity.getPassword());
        getUserResponse.setCreateUserDate(userEntity.getCreateUserDate());
        getUserResponse.setMail(userEntity.getMail());
        getUserResponse.setUpdatedOn(userEntity.getUpdatedOn());
        getUserResponse.setUserName(userEntity.getUserName());

        return getUserResponse;
    }

}
