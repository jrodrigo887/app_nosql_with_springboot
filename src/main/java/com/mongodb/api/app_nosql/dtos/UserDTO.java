package com.mongodb.api.app_nosql.dtos;
import java.io.Serializable;
import com.mongodb.api.app_nosql.domain.User;

public class UserDTO implements Serializable {
    static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    private int postCount;

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
       
    }

    public UserDTO() {
    }

    public UserDTO(User objUser) {
        this.id = objUser.getId();
        this.name = objUser.getName();
        this.email = objUser.getEmail();
        this.postCount = objUser.getPosts().size();
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }
}
