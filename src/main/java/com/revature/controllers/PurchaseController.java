package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.models.Purchase;
import com.revature.models.User;
import com.revature.services.PurchaseService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/api/purchase")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "https://fireshop.azurewebsites.net"}, allowCredentials = "true")
public class PurchaseController {

    PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @Authorized
    @PostMapping
    public List<Purchase> addPurchaseItems(@RequestBody List<Purchase> list){
        return purchaseService.addPurchase(list);
    }

    @Authorized
    @GetMapping
    public List<Purchase> getPurchaseItems(HttpSession session){
        return purchaseService.getPurchase((User) session.getAttribute("user"));
    }

}
