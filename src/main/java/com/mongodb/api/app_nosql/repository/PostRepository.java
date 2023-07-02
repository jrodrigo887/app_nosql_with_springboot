package com.mongodb.api.app_nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.api.app_nosql.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {}
