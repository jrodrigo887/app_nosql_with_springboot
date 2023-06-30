package com.mongodb.api.app_nosql.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.api.app_nosql.domain.User;
import com.mongodb.api.app_nosql.dtos.UserDTO;
import com.mongodb.api.app_nosql.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> index() {
        List<User> users = service.findAll();
        List<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok(new UserDTO(user));
    }
}
