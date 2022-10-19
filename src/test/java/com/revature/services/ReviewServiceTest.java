package com.revature.services;

import com.revature.models.Product;
import com.revature.models.Review;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReviewServiceTest {
 @Autowired
    ReviewService reviewService ;
 @Test
    void addReview(){
     Review review = new Review();
     Product product = new Product();
     User user = new User();
     product.setId(1);
     user.setId(1);
     review.setProduct(product);
     review.setUser(user);
     review.setReview("nice product");
  System.out.println(reviewService.save(review));


 }
}