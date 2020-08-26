package com.nimble00.userservice.services;

import com.nimble00.userservice.dtos.UserRequestModel;
import com.nimble00.userservice.dtos.UserResponseModel;

public interface UserService {
    public UserResponseModel addUser(UserRequestModel userRequestModel);
    public UserResponseModel updateUser(UserRequestModel userRequestModel);
}
