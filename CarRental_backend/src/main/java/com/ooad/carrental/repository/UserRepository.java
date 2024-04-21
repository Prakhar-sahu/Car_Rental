package com.ooad.carrental.repository;

import com.ooad.carrental.model.account.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>{
    public User findByEmail(String email);
}
