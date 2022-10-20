package com.revature.services;

import com.revature.models.Cart;
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

    public Cart addCartItems(Cart cart){
        Optional<Cart> optionalCart = cartRepository.findCartByUserAndAndProduct(cart.getUser(), cart.getProduct());
        if(!optionalCart.isPresent()){
            return cartRepository.save(cart);
        }
        Cart existingCartItem = optionalCart.get();
        existingCartItem.setQuantity(cart.getQuantity());
        existingCartItem.setTotal_price(cart.getTotal_price());
        return cartRepository.save(existingCartItem);
    }

    public void deleteCartItem(int id){
        cartRepository.deleteById(id);
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
