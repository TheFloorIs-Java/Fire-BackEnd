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

    /**
     * This method is used to get user cart from database by user
     * @param user This is the  parameter of findCartByUser method
     * @return List<Cart> This returns  list of user cart object.
     */
    List<Cart> findCartByUser(User user);

    /**
     * This method is used to delete  cart object from  database by user
     * @param user This is the  parameter of deleteAllByUser method
     * @return Nothing.
     */
    @Modifying
    void deleteAllByUser(User user);

    /**
     * This method is used to delete  cart object from  database by user and product
     * @param product This is the first parameter to deleteCartByProductAndUser method
     * @param user This is the second parameter to deleteCartByProductAndUser method
     * @return Nothing.
     */
    @Modifying
    void deleteCartByProductAndUser(Product product, User user);

    /**
     * This method is used to get user cart from database by user and product
     * @param user This is the first  parameter to findCartByUserAndAndProduct method
     * @param product This is the second parameter of findCartByUserAndAndProduct method
     * @return Optional<Cart> This returns   user cart object.
     */
    Optional<Cart> findCartByUserAndAndProduct(User user, Product product);

    /**
     * This method is used to get sum of quantity from cart table by user_id
     * @param user_id This is the  parameter of sumQuantity method
     * @return Integer This returns sum of quantity.
     */
    @Query(
            nativeQuery = true,
            value = "SELECT sum(c.quantity) FROM cart c WHERE user_id=?1"
    )
    Integer sumQuantity(int user_id);

    /**
     * This method is used to get sum of total price  from cart table by user_id
     * @param user_id This is the  parameter of getTotalPrice method
     * @return Integer This returns sum of quantity.
     */
    @Query(
            nativeQuery = true,
            value = "SELECT sum(c.total_price) FROM cart c WHERE user_id=?1"
    )
    Double getTotalPrice(int user_id);
}
