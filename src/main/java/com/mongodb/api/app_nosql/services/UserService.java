package com.mongodb.api.app_nosql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.api.app_nosql.domain.User;
import com.mongodb.api.app_nosql.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        if (user == null) {
            throw new ObjectNotFoundError("Não foi possível encontrar o usuário com id: "+id);
        }
        return user.get();
    }

    public void insertUser(User user) {
        repo.insert(user);
    }
}
