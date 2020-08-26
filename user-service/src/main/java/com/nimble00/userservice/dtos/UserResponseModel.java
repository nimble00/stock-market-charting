package com.nimble00.userservice.dtos;

import lombok.Data;

@Data
public class UserResponseModel {
    private String username;
    private String userType; // "admin" or "user"
    private String email;
    private boolean confirmed;
}
