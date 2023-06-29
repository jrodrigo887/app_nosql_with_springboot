package com.mongodb.api.app_nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodb.api.app_nosql.domain.User;

public interface UserRepository extends MongoRepository<User, String> {}
