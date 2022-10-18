package com.revature.services;

import com.revature.models.User;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class AuthService {

    //creating a user service object.
    private final UserService userService;

    //accepting a user service object when creating a auth service object.
    public AuthService(UserService userService) {
        this.userService = userService;
    }

    //getting an optional user type. The email and password sent from the front end
    public Optional<User> findByCredentials(String email, String password) {
        return userService.findByCredentials(email, password);
    }

    public User register(User user) {
        return userService.save(user);
    }
}
