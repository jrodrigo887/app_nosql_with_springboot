package com.mongodb.api.app_nosql.services.mappers;

import com.mongodb.api.app_nosql.domain.User;
import com.mongodb.api.app_nosql.dtos.UserDTO;

public abstract class UserMapper {
    public static UserDTO toDto(User obj) {
        return new UserDTO(obj);
    }

    public static User fromDTO(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
