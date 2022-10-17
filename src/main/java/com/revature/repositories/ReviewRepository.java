package com.revature.repositories;

import com.revature.models.Review;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {



}
