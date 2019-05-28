package com.gg.dls.service.authentication.controller;

import com.gg.dls.service.authentication.message.response.UserResponse;
import com.gg.dls.service.authentication.model.User;
import com.gg.dls.service.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user/")
@RestController
public class UserRestAPIs {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/details/{id}")
    public UserResponse getUserDetails(@PathVariable("id") Long userId){

        User dbUser = userRepository.findUserById(Long.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Id found."));

        UserResponse user = new UserResponse(dbUser.getName(), dbUser.getUsername(), dbUser.getEmail());
        return user;
    }


}
