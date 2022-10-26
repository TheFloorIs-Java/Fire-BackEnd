package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.models.Cart;
import com.revature.models.Product;
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

    /**
     * This method is used to get cart  objects from database
     * @param session This is the  parameter of getCartItems method
     * @return List<Cart> This returns  List pf cart  objects.
     */
    @Authorized
    @GetMapping
    public List<Cart> getCartItems(HttpSession session){
        return cartService.getUserCart((User)session.getAttribute("user"));
    }

    /**
     * This method is used to add cart to database
     * @param product This is the first parameter to addCartItem method
     * @param session This is the second parameter to addCartItem method
     * @return Cart This returns  cart object.
     */
    @Authorized
    @PostMapping("/add")
    public Cart addCartItem(@RequestBody Product product, HttpSession session){
        return cartService.addCartItems(product, (User) session.getAttribute("user"));
    }

    /**
     * This method is used to delete  cart from database by id
     * @param id This is the first parameter to deleteCartItem method
     * @param session This is the second parameter to deleteCartItem method
     * @return Nothing.
     */
    @Authorized
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteCartItem(@PathVariable int id, HttpSession session){
        cartService.deleteCartItem(Product.builder().id(id).build(), (User) session.getAttribute("user"));
    }

    /**
     * This method is used to delete cart items  from database
     * @param session This is the  parameter of emptyCart method
     * @return Nothing.
     */
    @Authorized
    @DeleteMapping
    @Transactional
    public void emptyCart(HttpSession session){
        cartService.emptyCart((User) session.getAttribute("user"));
    }

    /**
     * This method is used to get the number of carts   from database
     * @param session This is the  parameter of getCartCount method
     * @return int This returns  the number of carts.
     */
    @Authorized
    @GetMapping("/count")
    public int getCartCount(HttpSession session){
        return cartService.getCartCount((User) session.getAttribute("user"));
    }

    /**
     * This method is used to get the total price  of cart  from database
     * @param session This is the  parameter of getCartTotalPrice method
     * @return int This returns  the total price  of cart.
     */
    @Authorized
    @GetMapping("/total")
    public double getCartTotalPrice(HttpSession session){
        return cartService.getCartTotalPrice((User) session.getAttribute("user"));
    }
}
