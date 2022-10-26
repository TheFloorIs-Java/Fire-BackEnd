package com.revature.services;

import com.revature.models.Cart;
import com.revature.models.Purchase;
import com.revature.models.User;
import com.revature.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CartService cartService;
    /**
     * This method is used to add purchase object to the  database
     * @param user This is the  parameter of addPurchase method
     * @return List<Purchase> This returns list of purchase objects.
     */
    public List<Purchase> addPurchase(User user){
        List<Cart> cartList = cartService.getUserCart(user);
        List<Purchase> purchaseList = new ArrayList<>();
        Date date = new Date();
        for (Cart cart: cartList){
            Purchase purchase = Purchase.builder()
                    .product(cart.getProduct())
                    .user(user)
                    .total_price(cart.getTotal_price())
                    .date(date)
                    .quantity(cart.getQuantity())
                    .build();
            purchaseList.add(purchase);
        }

        purchaseList = purchaseRepository.saveAll(purchaseList);
        if (!purchaseList.isEmpty()){
            cartService.emptyCart(user);
            return purchaseList;
        }
        return null;
    }
    /**
     * This method is used to get  purchases from database
     * @param user This is the  parameter of getPurchase method
     * @return List<Review> This returns  list of purchase objects.
     */
    public List<Purchase> getPurchase(User user){
        return purchaseRepository.findPurchaseByUser(user);
    }
    /**
     * This method is used to delete  purchase object from  database by id
     * @param id This is the  parameter of deletePurchase method
     * @return Nothing.
     */
    public void deletePurchase(int id){
        purchaseRepository.deleteById(id);
    }
}
