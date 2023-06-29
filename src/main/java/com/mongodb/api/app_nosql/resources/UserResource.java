package com.mongodb.api.app_nosql.resources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.api.app_nosql.domain.User;
import com.mongodb.api.app_nosql.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<User>> index() {
        List<User> users = service.findAll();
         
        return ResponseEntity.ok(users);
    }
}
