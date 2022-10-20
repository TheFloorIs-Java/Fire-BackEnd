package com.revature.services;

import com.revature.models.Purchase;
import com.revature.models.User;
import com.revature.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase> addPurchase(List<Purchase> purchaseList){
        return purchaseRepository.saveAll(purchaseList);
    }

    public List<Purchase> getPurchase(User user){
        return purchaseRepository.findPurchaseByUser(user);
    }

    public void deletePurchase(int id){
        purchaseRepository.deleteById(id);
    }
}
