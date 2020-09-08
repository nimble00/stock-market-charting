package com.nimble00.userservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
    private Long id;
    private String fullname;
    private String password;
    private String usertype; // "admin" or "user"
    private String email;
    private String phone;
    private boolean confirmed;
}
