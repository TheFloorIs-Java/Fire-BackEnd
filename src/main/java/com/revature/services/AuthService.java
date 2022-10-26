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

    /**
     * This method is used to find user objects in database by email and password
     * @param email This is the first parameter to findByCredentials method
     * @param password This is the second parameter to findByCredentials method
     * @return Optional<User> This returns  not-null User  object.
     */
    //getting an optional user type. The email and password sent from the front end
    public Optional<User> findByCredentials(String email, String password) {
        return userService.findByCredentials(email, password);
    }

    /**
     * This method is used to save User object in database
     * @param user This is the  parameter of register method
     * @return User This returns user object.
     */
    public User register(User user) {
        return userService.save(user);
    }
}
