package com.gg.dls.service.authentication.message.response;

import com.gg.dls.service.authentication.message.request.SignUpForm;
import com.gg.dls.service.authentication.model.User;
import org.springframework.http.ResponseEntity;

public class UserResponse {

    private Long id;
    private String name;
    private String username;
    private String email;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }


    public UserResponse(Long id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
