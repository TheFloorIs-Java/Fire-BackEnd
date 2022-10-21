package com.revature.repositories;


import com.revature.models.Cart;
import com.revature.models.Product;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findCartByUser(User user);

    @Modifying
    void deleteAllByUser(User user);

    @Modifying
    void deleteCartByProductAndUser(Product product, User user);

    Optional<Cart> findCartByUserAndAndProduct(User user, Product product);

    @Query(
            nativeQuery = true,
            value = "SELECT sum(c.quantity) FROM cart c WHERE user_id=?1"
    )
    Integer sumQuantity(int user_id);
}
