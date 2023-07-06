package com.mongodb.api.app_nosql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongodb.api.app_nosql.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    // exemplo de query method
    List<Post> findByTitleContaining(String text);

    // exemplo de query raw mongoDB
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

}
