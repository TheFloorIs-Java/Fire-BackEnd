package com.revature.repositories;

import com.revature.models.Product;
import com.revature.models.Review;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    //@Query("from reviews where product_id = :id")
   // public List<Review> getReviewsByProductId(@Param("id") int id);

    /**
     * This method is used to get  reviews from database by product
     * @param product This is the  parameter of findReviewByProduct method
     * @return List<Review> This returns  list of Review objects.
     */
    List<Review> findReviewByProduct( Product product) ;


}
