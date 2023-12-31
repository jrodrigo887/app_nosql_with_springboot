package com.mongodb.api.app_nosql.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mongodb.api.app_nosql.domain.Post;
import com.mongodb.api.app_nosql.domain.User;
import com.mongodb.api.app_nosql.dtos.UserDTO;
import com.mongodb.api.app_nosql.services.UserService;
import com.mongodb.api.app_nosql.services.mappers.UserMapper;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> index() {
        List<User> users = service.findAll();
        List<UserDTO> listDto = users.stream().map(x -> UserMapper.toDto(x)).toList();
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPost(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok(user.getPosts());
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDto) {
        User user = UserMapper.fromDTO(userDto);
        var result = service.insertUser(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/"+result.getId())
                .buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(UserMapper.toDto(result));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDto, @PathVariable String id) {
        User user = UserMapper.fromDTO(userDto);
        user.setId(id);
        service.update(user);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
