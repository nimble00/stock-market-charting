package com.nimble00.userservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String fullname;
    private String usertype; // "admin" or "user"
    private String email;
    private String phone;
    private boolean confirmed;
}
