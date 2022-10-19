package com.revature.services;

import com.revature.models.Product;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {
    private final ReviewRepository rr;

    public ReviewService (ReviewRepository rr){
        this.rr = rr;

    }

    public Review save(Review review) {
        return rr.save(review);
    }


   // public List<Review> getAllReviewsByProductId(int id) {
    //    List<Review> reviews = rr.getReviewsByProductId(id);
    //    return reviews ;

  //  }

    public List<Review> getAllReviews( Product product) {

        return rr.findReviewByProduct(product) ;

    }

    public List<Review> getAllReview() {

        return rr.findAll() ;

    }

}
