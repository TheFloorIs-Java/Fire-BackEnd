package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * This method is used to find user object in database by email and password
     * @param email This is the first parameter to findByCredentials method
     * @param password This is the second parameter to findByCredentials method
     * @return Optional<User> This returns  not-null User  object.
     */
    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    /**
     * This method is used to save User object in database
     * @param user This is the  parameter of Save method
     * @return User This returns user object.
     */
    public User save(User user) {
        return userRepository.save(user);
    }
}
