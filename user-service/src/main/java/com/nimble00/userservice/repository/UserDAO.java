package com.nimble00.userservice.repository;

import com.nimble00.userservice.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, String> {

}
