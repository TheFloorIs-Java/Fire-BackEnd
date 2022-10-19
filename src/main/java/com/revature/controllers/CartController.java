package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.models.Cart;
import com.revature.models.User;
import com.revature.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cart")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "https://fireshop.azurewebsites.net"}, allowCredentials = "true")
public class CartController {


    CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @Authorized
    @GetMapping
    public List<Cart> getCartItems(HttpSession session){
        return cartService.getUserCart((User)session.getAttribute("user"));
    }

    @Authorized
    @PostMapping
    public Cart addCartItem(@RequestBody Cart cart){
        return cartService.addCartItems(cart);
    }
}
