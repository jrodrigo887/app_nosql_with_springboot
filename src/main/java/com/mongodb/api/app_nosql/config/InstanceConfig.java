package com.mongodb.api.app_nosql.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongodb.api.app_nosql.domain.Post;
import com.mongodb.api.app_nosql.domain.User;
import com.mongodb.api.app_nosql.dtos.AuthorDTO;
import com.mongodb.api.app_nosql.dtos.CommentDTO;
import com.mongodb.api.app_nosql.repository.PostRepository;
import com.mongodb.api.app_nosql.repository.UserRepository;

@Configuration
public class InstanceConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepository.deleteAll();
        var us1 = new User(null, "João", "joao@email.com");
        var us2 = new User(null, "Silva", "silva@email.com");
        var us3 = new User(null, "Filipe", "filipe@email.com");
        var us4 = new User(null, "Maria", "mariape@email.com");
        var us5 = new User(null, "Aline", "aline@email.com");
        var us6 = new User(null, "Lua", "lua@email.com");
        
        repository.saveAll(Arrays.asList(us1, us2, us3, us4, us5, us6));

        Post post1 = new Post(null, "Correntes marítimas", "Para entender melhor...", new AuthorDTO(us1));
        Post post3 = new Post(null, "Dados quebrado", "Para entender melhor...", new AuthorDTO(us1));

        CommentDTO cmt1 = new CommentDTO("muito legal", sdf.parse("27/06/2023"), new AuthorDTO(us2));
        CommentDTO cmt2 = new CommentDTO("muito legal", sdf.parse("27/06/2023"), new AuthorDTO(us3));

        post1.setComments(Arrays.asList(cmt1, cmt2));

        postRepository.saveAll(Arrays.asList(post1, post3));
        // postRepository.saveAll(Arrays.asList(post1, post3));

        us1.setPosts(Arrays.asList(post1, post3));
        repository.save(us1);
    }
    
}
