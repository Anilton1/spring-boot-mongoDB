package com.araujo.estudomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.araujo.estudomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
