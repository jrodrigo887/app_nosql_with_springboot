package com.mongodb.api.app_nosql.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.api.app_nosql.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> index() {
        List<User> users = new ArrayList<>();
            
        var us1 = new User("1", "João", "joao@email.com");
        var us2 = new User("2", "Silva", "joao@email.com");
        var us3 = new User("3", "Filipe", "joao@email.com");
        users.addAll(Arrays.asList(us1, us2, us3));

        return ResponseEntity.ok(users);
    }
}
