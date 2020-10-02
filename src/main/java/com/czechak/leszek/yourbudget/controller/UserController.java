package com.czechak.leszek.yourbudget.controller;

import com.czechak.leszek.yourbudget.configuration.util.JwtUtil;
import com.czechak.leszek.yourbudget.dto.user.*;
import com.czechak.leszek.yourbudget.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    (new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username or Password", e);
        }

        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> createRequestUser(@RequestBody CreateUserRequest newUser) {
        userService.createUser(newUser);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/")
    public ResponseEntity<GetUserResponse> getCurrentUserData() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PutMapping("/")
    public ResponseEntity<Void> editUser(@RequestBody EditUserRequest editUser) {
        userService.editUser(editUser);
        return ResponseEntity.ok(null);
    }

}
