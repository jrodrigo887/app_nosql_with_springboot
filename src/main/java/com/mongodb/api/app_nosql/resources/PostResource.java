package com.mongodb.api.app_nosql.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.api.app_nosql.domain.Post;
import com.mongodb.api.app_nosql.resources.utils.URL;
import com.mongodb.api.app_nosql.services.PostService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/searchTitle")
    public ResponseEntity<List<Post>> findByTitle(@PathParam(value = "text") String text) {
        text = URL.decode(text);

        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
}
