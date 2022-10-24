package com.revature.services;

import com.revature.models.Product;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * The ReviewService program implements an application that
 * simply save Review object in database, get all reviews form
 * database  and get all reviews form database  filter by product_id.
 */
@Service
public class ReviewService {
    // define ReviewRepository object as private
    private final ReviewRepository rr;
    /** This  constructor is used to initialize ReviewRepository rr
     *@return Nothing.
     * @param rr This is parameter to ReviewService constructor
     */
    public ReviewService (ReviewRepository rr){
        this.rr = rr;

    }
    /**
     * This method is used to save Review object in database
     * @param review This is the first paramter to Save method
     * @return Review This returns Review object.
     */
    public Review save(Review review) {
        return rr.save(review);
    }




//    public List<Review> getAllReviews( Product product) {
//
//        return rr.findReviewByProduct(product) ;
//
//    }
    /**
     * This method is used to get all  reviews from database
     * @return List<Review> This returns  list of Review object.
     */
    public List<Review> getAllReview() {

        return rr.findAll() ;

    }
    /**
     * This method is used to get all  reviews from database by product_id
     * @param id This is the  parameter to findById method
     * @return List<Review> This returns  list of Review object.
     */
    public List<Review> findById(int id) {
        Product product = new Product();
        product.setId(id);
        return rr.findReviewByProduct(product);
    }

}
