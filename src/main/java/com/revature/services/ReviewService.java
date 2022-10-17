package com.revature.services;

import com.revature.models.Review;
import com.revature.models.User;
import com.revature.repositories.ReviewRepository;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService (ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;

    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }


}
