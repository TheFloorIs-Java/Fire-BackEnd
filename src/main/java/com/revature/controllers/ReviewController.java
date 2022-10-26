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
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "https://fireshop.azurewebsites.net", "https://fire-store.azurewebsites.net"}, allowCredentials = "true")
public class ReviewController {

    private final ReviewService rs ;
    @Autowired
    public ReviewController(ReviewService rs){
        this.rs = rs;
    }

    /**
     * This method is used to save review  object  to the  database
     * @param r This is the first parameter to addReview method
     * @param session This is the second parameter to addReview method
     * @return Review This returns review  object.
     */
    @Authorized
    @PostMapping("/review")
    public Review addReview(@RequestBody Review r, HttpSession session){
        User user = (User) session.getAttribute("user");
        r.setUser(user);
        return rs.save(r);
    }

    /**
     * This method is used to get review  objects  from the  database by product
     * @param product This is the first parameter to getAllReviews method
     * @return List<Review> This returns  list of review  object.
     */
    @GetMapping("/review")
    public List<Review> getAllReviews(@RequestBody Product product){

        return rs.getAllReviews(product);
    }


    /**
     * This method is used to get review  objects  from the  database by id
     * @param id This is the  parameter of getAllReviews method
     * @return List<Review> This returns  list of review  object.
     */

    @Authorized
    @GetMapping("/review/{id}")
    public List<Review> getAllReviews(@PathVariable int id){

        return rs.findReviewsByProduct(Product.builder().id(id).build());
    }






}
