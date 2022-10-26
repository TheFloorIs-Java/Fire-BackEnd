package com.revature.services;

import com.revature.models.Cart;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    /**
     * This method is used to add cart object to database
      * @param product This is the first parameter to addCartItems method
      * @param user This is the second parameter to addCartItems method
     * @return Cart This returns cart object.
     */
    public Cart addCartItems(Product product, User user){
        Cart cart = Cart.builder()
                .user(user)
                .product(product)
                .quantity(1)
                .total_price(product.getPrice())
                .build();

        Optional<Cart> optionalCart = cartRepository.findCartByUserAndAndProduct(user, product);
        if(!optionalCart.isPresent()){
            return cartRepository.save(cart);
        }
        Cart existingCartItem = optionalCart.get();
        existingCartItem.setQuantity(existingCartItem.getQuantity() + cart.getQuantity());
        existingCartItem.setTotal_price(existingCartItem.getTotal_price() + cart.getTotal_price());
        return cartRepository.save(existingCartItem);
    }

    /**
     * This method is used to delete  cart object from  database by product and user
     * @param product This is the first parameter to deleteCartItem method
     * @param user This is the second parameter to deleteCartItem method
     * @return Nothing.
     */
    @Transactional
    public void deleteCartItem(Product product, User user){
        cartRepository.deleteCartByProductAndUser(product, user);
    }

    /**
     * This method is used to delete  cart items   from  database by  user
     * @param user This is the  parameter of emptyCart method
     * @return Nothing.
     */
    @Transactional
    public void emptyCart(User user){
        cartRepository.deleteAllByUser(user);
    }

    /**
     * This method is used to get user cart from database by user
     * @param user This is the  parameter of getUserCart method
     * @return List<Cart> This returns  list of user cart object.
     */
    public List<Cart> getUserCart(User user){
        return cartRepository.findCartByUser(user);
    }

    /**
     * This method is used to get the number of carts from database by user
     * @param user This is the  parameter of getCartCount method
     * @return int This returns  the number of  carts.
     */
    public int getCartCount(User user){
        try {
            return cartRepository.sumQuantity(user.getId());
        }
        catch (NullPointerException e){
            return 0;
        }
    }
    /**
     * This method is used to get  total price of  cart from database by user
     * @param user This is the  parameter of getCartTotalPrice method
     * @return double This returns total price of user cart.
     */
    public double getCartTotalPrice(User user){
        try {
            return cartRepository.getTotalPrice(user.getId());
        }
        catch (NullPointerException e){
            return 0;
        }
    }

}
