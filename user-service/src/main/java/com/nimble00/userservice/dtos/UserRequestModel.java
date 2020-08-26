package com.nimble00.userservice.dtos;

import lombok.Data;

@Data
public class UserRequestModel {
    private String id;
    private String username;
    private String password;
    private String userType; // "admin" or "user"
    private String email;
    private boolean confirmed;
}
