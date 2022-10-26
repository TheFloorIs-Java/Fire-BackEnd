package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.dtos.LoginRequest;
import com.revature.dtos.RegisterRequest;
import com.revature.models.User;
import com.revature.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "https://fireshop.azurewebsites.net"}, allowCredentials = "true")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * This method is used to get user object from  database by loginRequest   (email and password)
     * @param loginRequest This is the first parameter to login method
     * @param session This is the second parameter to login method
     * @return User This returns   user  object.
     */
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        Optional<User> optional = authService.findByCredentials(loginRequest.getEmail(), loginRequest.getPassword());
        System.out.println(loginRequest.getEmail()+" "+loginRequest.getPassword());

        if(!optional.isPresent()) {
            //return ResponseEntity.badRequest().build();
            return null;
        }
        System.out.println(optional.get().getId());
        session.setAttribute("user", optional.get());
        System.out.println(session.getAttribute("user").toString()+"00000");
        //return ResponseEntity.ok(optional.get());
        return optional.get();
    }

    /**
     * This method is used to log out by remove user from session
     * @param session This is the  parameter of logout method
     * @return ResponseEntity<Void> This returns  ResponseEntity  object.
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.removeAttribute("user");

        return ResponseEntity.ok().build();
    }

    /**
     * This method is used to save user object in database
     * @param registerRequest This is the  parameter of register method
     * @return ResponseEntity<User> This returns  user  object.
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User created = new User(0,
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getFirstName(),
                registerRequest.getLastName());

        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(created));
    }

    /**
     * This method is used to get user object from database
     * @param session This is the  parameter of getUser method
     * @return User This returns  user  object.
     */
    @Authorized
    @GetMapping("/user")
    public User getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return authService.findByCredentials(user.getEmail(), user.getPassword()).get();
    }


    @Authorized
    @GetMapping("/userInfo")
    public User getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user;
    }
}
