package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.model.UserEntity;
import org.springframework.stereotype.Component;



@Component
public class UserContext {

    private UserEntity userEntity;

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity getCurrentUser() {
        return userEntity;
    }
}
