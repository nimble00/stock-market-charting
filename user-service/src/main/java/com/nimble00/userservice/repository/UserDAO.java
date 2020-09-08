package com.nimble00.userservice.repository;

import com.nimble00.userservice.models.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<MyUser, Long> {
    public MyUser findByEmail(String email);
    public MyUser findByPhone(String phone);
}
