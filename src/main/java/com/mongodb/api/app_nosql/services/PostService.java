package com.mongodb.api.app_nosql.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.api.app_nosql.domain.Post;
import com.mongodb.api.app_nosql.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        if (post == null) {
            throw new ObjectNotFoundError("Não foi possível encontrar o usuário com id: "+id);
        }
        return post.get();
    }
}
