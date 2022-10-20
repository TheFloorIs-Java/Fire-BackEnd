package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.models.Cart;
import com.revature.models.User;
import com.revature.services.CartService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
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
    @PostMapping("/add")
    public Cart addCartItem(@RequestBody Cart cart){
        return cartService.addCartItems(cart);
    }

    @Authorized
    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable int id){
        cartService.deleteCartItem(id);
    }

    @Authorized
    @DeleteMapping
    @Transactional
    public void emptyCart(HttpSession session){
        cartService.emptyCart((User) session.getAttribute("user"));
    }

    @Authorized
    @GetMapping("/count")
    public int getCartCount(HttpSession session){
        return cartService.getCartCount((User) session.getAttribute("user"));
    }
}
