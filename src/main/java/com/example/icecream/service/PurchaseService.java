package com.example.icecream.service;

import com.example.icecream.entity.Purchase;
import com.example.icecream.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Optional<Purchase> getPurchaseById(UUID id) {
        return purchaseRepository.findById(id);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public List<Purchase> getPurchasesByCustomerId(UUID customerId) {
        return purchaseRepository.findByCustomer_Id(customerId);
    }

    public List<Purchase> getPurchasesByCreatedAt(LocalDateTime createdAt) {
        return purchaseRepository.findByCreatedAt(createdAt);
    }
}

