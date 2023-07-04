package com.mongodb.api.app_nosql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.api.app_nosql.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContaining(String text);
}
