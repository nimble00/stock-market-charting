package com.nimble00.userservice.services;

import com.nimble00.userservice.dtos.UserRequest;
import com.nimble00.userservice.dtos.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public UserResponse addUser(UserRequest userRequest);
    public UserResponse updateUser(UserRequest userRequest, Long id);
    public UserDetails loadUserByUsername(String email);
    public UserResponse findUserByEmail(String email);
}
