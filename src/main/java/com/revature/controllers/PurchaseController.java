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
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "https://fireshop.azurewebsites.net", "https://fire-store.azurewebsites.net"}, allowCredentials = "true")
public class PurchaseController {

    PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    /**
     * This method is used to save purchase  objects  to the  database
     * @param session This is the  parameter of addPurchaseItems method
     * @return List<Purchase> This returns list of  purchase  objects.
     */
    @Authorized
    @PostMapping
    public List<Purchase> addPurchaseItems(HttpSession session){
        return purchaseService.addPurchase((User) session.getAttribute("user"));
    }

    /**
     * This method is used to get purchase objects from the  database
     * @param session This is the  parameter of getPurchaseItems method
     * @return List<Purchase> This returns list of  purchase  objects.
     */
    @Authorized
    @GetMapping
    public List<Purchase> getPurchaseItems(HttpSession session){
        return purchaseService.getPurchase((User) session.getAttribute("user"));
    }

}
