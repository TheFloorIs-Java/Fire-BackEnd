package com.revature.services;

import com.revature.models.Cart;
import com.revature.models.Product;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceTest {

    @Autowired
    CartService cartService;

    @Test
    void addCartItem(){
        Product product = Product.builder().id(1).build();
        User user = User.builder().id(1).build();

        Cart cart = Cart.builder()
                .product(product)
                .user(user)
                .quantity(1)
                .total_price(20)
                .build();
        System.out.println(cartService.addCartItems(cart));
    }

    @Test
    void getCartItems(){
        User user = User.builder().id(1).build();
        System.out.println(cartService.getUserCart(user));
    }

    @Test
    void deleteCartItem(){
        cartService.deleteCartItem(1);
    }

    @Test
    void emptyCart(){

        cartService.emptyCart(User.builder().id(1).build());
    }

    @Test
    void getCartCount(){
        System.out.println(cartService.getCartCount(User.builder().id(2).build()));
    }
}