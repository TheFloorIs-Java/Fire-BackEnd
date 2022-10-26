package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * This method is used to get user  from database by email and password
     * @param email This is the first parameter to findByEmailAndPassword method
     * @param password This is the second parameter to findByEmailAndPassword method
     * @return Optional<User> This returns user object.
     */
    Optional<User> findByEmailAndPassword(String email, String password);
}
