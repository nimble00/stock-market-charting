package com.nimble00.userservice.controllers;

import com.nimble00.userservice.dtos.UserRequest;
import com.nimble00.userservice.dtos.UserResponse;
import com.nimble00.userservice.models.LoginRequest;
import com.nimble00.userservice.models.MyUser;
import com.nimble00.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = {"myToken"})
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private Environment env;
//    @Autowired
//    AuthenticationManager authenticationManager;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/test")
    public String test() {
        return "user service is working";
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createAccount(@RequestBody UserRequest userRequest) {
        UserResponse user = userService.addUser(userRequest);
        if (user==null) { return ResponseEntity.badRequest().body(null); }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUserInfo(@RequestBody UserRequest userRequest, @PathVariable Long id) {
        UserResponse user = userService.updateUser(userRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/email/{mail}")
    public ResponseEntity<UserResponse> getUserInfo(@PathVariable String mail) {
        UserResponse user = userService.findUserByEmail(mail);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

//    @PostMapping("/login")
//    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
//        );
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        UserResponse user = userService.findUserByEmail(loginRequest.getEmail());
//        if (user==null) return null;
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//    }


}
