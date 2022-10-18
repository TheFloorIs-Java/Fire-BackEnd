package com.revature.services;

import com.revature.models.Cart;
import com.revature.models.Product;
import com.revature.models.Purchase;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PurchaseServiceTest {

    @Autowired
    PurchaseService purchaseService;

    @Test
    void savePurchase(){
        Product product = Product.builder().id(2).build();
        User user = User.builder().id(1).build();
        Date date = new Date();
        ArrayList<Purchase> purchases = new ArrayList<>();

        Purchase purchase = Purchase.builder()
                .product(product)
                .user(user)
                .quantity(1)
                .total_price(45)
                .build();
        purchases.add(purchase);
        product = Product.builder().id(1).build();
        user = User.builder().id(1).build();
        date = new Date();
        purchase = Purchase.builder()
                .product(product)
                .user(user)
                .quantity(1)
                .total_price(20)
                .build();
        purchases.add(purchase);


        System.out.println(purchaseService.addPurchase(purchases));
    }

    @Test
    void getCartItems(){
        User user = User.builder().id(1).build();
        System.out.println(purchaseService.getPurchase(user));
    }
}