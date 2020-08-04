package com.czechak.leszek.your_budget.controller;

import com.czechak.leszek.your_budget.dto.user.CreateUserRequest;
import com.czechak.leszek.your_budget.dto.user.EditUserRequest;
import com.czechak.leszek.your_budget.dto.user.GetUserResponse;
import com.czechak.leszek.your_budget.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

     @GetMapping("/user")
     public ResponseEntity<GetUserResponse> getCurrentUserData(){
          return ResponseEntity.ok(userService.getCurrentUser());
     }

     @PutMapping("/user")
     public ResponseEntity<Void> editUser (@RequestBody EditUserRequest editUser){
          userService.editUser(editUser);
          return ResponseEntity.ok(null);
     }

}
