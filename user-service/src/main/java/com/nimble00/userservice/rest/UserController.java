package com.nimble00.userservice.rest;

import com.nimble00.userservice.dtos.UserRequestModel;
import com.nimble00.userservice.dtos.UserResponseModel;
import com.nimble00.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "user service is working";
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseModel> createAccount(@RequestBody UserRequestModel userRequestModel) {
        UserResponseModel user = userService.addUser(userRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PatchMapping("/updateInfo")
    public ResponseEntity<UserResponseModel> updateUserInfo(@RequestBody UserRequestModel userRequestModel) {
        UserResponseModel user = userService.updateUser(userRequestModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }
}
