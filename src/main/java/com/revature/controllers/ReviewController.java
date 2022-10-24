package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.models.Product;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "https://fireshop.azurewebsites.net"}, allowCredentials = "true")
public class ReviewController {

    private final ReviewService rs ;
    @Autowired
    public ReviewController(ReviewService rs){
        this.rs = rs;
    }

    @Authorized
    @PostMapping("/review")
    public Review addReview(@RequestBody Review r, HttpSession session){
        User user = (User) session.getAttribute("user");
        r.setUser(user);
        return rs.save(r);
    }

    @Authorized
    @GetMapping("/review/{id}")
    public List<Review> getAllReviews(@PathVariable int id){

        return rs.findReviewsByProduct(Product.builder().id(id).build());
    }






}
