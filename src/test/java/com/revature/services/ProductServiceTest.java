package com.revature.services;

import com.revature.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void addProducts(){
        Product product = Product.builder()
                .quantity(10)
                .price(20)
                .description("A nice pair of headphones")
                .name("Headphones")
                .image("")
                .build();
        productService.save(product);
    }
}