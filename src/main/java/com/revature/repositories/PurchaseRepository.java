package com.revature.repositories;

import com.revature.models.Purchase;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    List<Purchase> findPurchaseByUser(User user);
}
