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

    @Transactional
    public void deleteCartItem(Product product, User user){
        cartRepository.deleteCartByProductAndUser(product, user);
    }

    @Transactional
    public void emptyCart(User user){
        cartRepository.deleteAllByUser(user);
    }

    public List<Cart> getUserCart(User user){
        return cartRepository.findCartByUser(user);
    }

    public int getCartCount(User user){
        try {
            return cartRepository.sumQuantity(user.getId());
        }
        catch (NullPointerException e){
            return 0;
        }
    }

}
