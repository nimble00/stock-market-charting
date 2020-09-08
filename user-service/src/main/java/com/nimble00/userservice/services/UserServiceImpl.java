package com.nimble00.userservice.services;

import com.nimble00.userservice.dtos.UserRequest;
import com.nimble00.userservice.dtos.UserResponse;
import com.nimble00.userservice.models.MyUser;
import com.nimble00.userservice.models.MyRole;
import com.nimble00.userservice.repository.UserDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private ModelMapper modelMapper;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    Environment environment;

    @Autowired
    public UserServiceImpl(Environment environment, UserDAO userDAO, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.environment = environment;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        String email = userRequest.getEmail();
        MyUser user = userDAO.findByEmail(email);
        if (user!=null) { return null; }
        userRequest.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        MyUser myUser = modelMapper.map(userRequest, MyUser.class);
        userDAO.save(myUser);
        ModelMapper mm = new ModelMapper();
        return mm.map(userDAO.findByEmail(email), UserResponse.class);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long id) {
        Optional<MyUser> optionalUser = userDAO.findById(id);
        MyUser myUser = optionalUser.get();
        myUser.setPhone(userRequest.getPhone());
        myUser.setFullname(userRequest.getFullname());
        myUser.setConfirmed(userRequest.isConfirmed());
        return modelMapper.map(myUser, UserResponse.class);
    }
    @Override
    public UserDetails loadUserByUsername(String email) {
        MyUser myUser = userDAO.findByEmail(email);
        return new User(myUser.getEmail(), myUser.getPassword(), true, true, true, true, new ArrayList<>());
    }

    @Override
    public UserResponse findUserByEmail(String email) {
        MyUser myUser = userDAO.findByEmail(email);
        return modelMapper.map(myUser, UserResponse.class);
    }
}
