package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.CreateUserRequest;
import com.czechak.leszek.your_budget.dto.EditUserRequest;
import com.czechak.leszek.your_budget.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

     UserService userService;

     public UserController(UserService userService) {
          this.userService = userService;
     }

     @PostMapping("/user")
     public ResponseEntity<Void> createRequestUser (@RequestBody CreateUserRequest newUser){
          userService.createUser(newUser);
          return ResponseEntity.ok(null);
     }

     // TODO: docelowo ma tu być jeszcze GET
     @PutMapping("/user")
     public ResponseEntity<Void> editUser (@RequestBody EditUserRequest editUser){
          userService.editUser(editUser);
          return ResponseEntity.ok(null);
     }

}
