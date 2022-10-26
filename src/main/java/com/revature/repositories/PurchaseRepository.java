package com.revature.repositories;

import com.revature.models.Purchase;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    /**
     * This method is used to get  purchase from database by user
     * @param user This is the  parameter of findPurchaseByUser method
     * @return List<Purchase> This returns  list of purchase objects.
     */
    List<Purchase> findPurchaseByUser(User user);
}
