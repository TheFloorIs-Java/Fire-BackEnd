package com.revature.services;

import com.revature.models.Cart;
import com.revature.models.User;
import com.revature.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart addCartItems(Cart cart){
        return cartRepository.save(cart);
    }

    public void deleteCartItem(int id){
        cartRepository.deleteById(id);
    }

    public List<Cart> getUserCart(User user){
        return cartRepository.findCartByUser(user);
    }

}
