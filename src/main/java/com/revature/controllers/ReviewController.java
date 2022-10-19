package com.revature.controllers;

import com.revature.models.Product;
import com.revature.models.Review;
import com.revature.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    private final ReviewService rs ;
    @Autowired
    public ReviewController(ReviewService rs){
        this.rs = rs;
    }

    @PostMapping("/review")
    public Review addReview(@RequestBody Review r){
        return rs.save(r);
    }



    @GetMapping("/review")
    public List<Review> getAllReviews(@RequestBody Product product){

        return rs.getAllReviews(product);
    }

    @GetMapping("/reviews")
    public List<Review> getAllReview(){

        return rs.getAllReview();
    }






}
