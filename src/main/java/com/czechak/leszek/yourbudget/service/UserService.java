package com.czechak.leszek.yourbudget.service;

import com.czechak.leszek.yourbudget.dto.user.CreateUserRequest;
import com.czechak.leszek.yourbudget.dto.user.EditUserRequest;
import com.czechak.leszek.yourbudget.dto.user.GetUserResponse;
import com.czechak.leszek.yourbudget.model.UserRole;
import com.czechak.leszek.yourbudget.repository.user.UserRepository;
import com.czechak.leszek.yourbudget.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserContext userContext;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserContext userContext, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userContext = userContext;
        this.passwordEncoder = passwordEncoder;
    }


    public void createUser (CreateUserRequest requestUser){

        UserEntity userEntity= new UserEntity();
        userEntity.setUsername(requestUser.getLogin());
        userEntity.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        userEntity.setCreateUserDate(LocalDateTime.now());
        userEntity.setUpdatedOn(LocalDateTime.now());
        userEntity.setAccountNonExpired(true);
        userEntity.setAccountNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnabled(true);
        userEntity.getRoles().add(UserRole.USER);
        userRepository.save(userEntity);

    }


    public void editUser(EditUserRequest editUser) {
        UserEntity userEntity= userContext.getCurrentUser();
        userEntity.setUsername(editUser.getLogin());
        userEntity.setUpdatedOn(LocalDateTime.now());
        userRepository.save(userEntity);
    }

    public GetUserResponse getCurrentUser(){
        UserEntity currentUser = userContext.getCurrentUser();

        GetUserResponse getUserResponse= new GetUserResponse();

        getUserResponse.setLogin(currentUser.getUsername());
        getUserResponse.setCreateUserDate(currentUser.getCreateUserDate());
        getUserResponse.setUpdatedOn(currentUser.getUpdatedOn());
        getUserResponse.setMail(currentUser.getMail());
        getUserResponse.setUserName(currentUser.getUsername());

        return getUserResponse;

    }

    public GetUserResponse getUserResponseByUserId (Long userId){

        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        UserEntity userEntity= optionalUserEntity.get();

        GetUserResponse getUserResponse= new GetUserResponse();

        getUserResponse.setLogin(userEntity.getUsername());
        getUserResponse.setPassword(userEntity.getPassword());
        getUserResponse.setCreateUserDate(userEntity.getCreateUserDate());
        getUserResponse.setMail(userEntity.getMail());
        getUserResponse.setUpdatedOn(userEntity.getUpdatedOn());
        getUserResponse.setUserName(userEntity.getUsername());

        return getUserResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserDetails> response = userRepository.loadUserByUsername(username);
        if(response.isPresent()){
            System.out.println(response.get().getUsername());
            System.out.println(response.get().getPassword());
        }
        return response.orElseThrow(()-> new UsernameNotFoundException(String.format("Username %s not found",username)));
    }
}
