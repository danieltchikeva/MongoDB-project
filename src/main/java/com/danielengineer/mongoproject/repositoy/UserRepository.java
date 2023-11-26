package com.danielengineer.mongoproject.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danielengineer.mongoproject.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
