package com.example.icecream.controller;

import com.example.icecream.model.Purchase;
import com.example.icecream.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase) {
        Purchase saved = purchaseService.savePurchase(purchase);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable UUID id) {
        Optional<Purchase> purchase = purchaseService.getPurchaseById(id);
        return purchase.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<Purchase> getPurchasesByCustomerId(@PathVariable UUID customerId) {
        return purchaseService.getPurchasesByCustomerId(customerId);
    }

    @GetMapping("/date")
    public List<Purchase> getPurchasesByCreatedAt(@RequestParam("createdAt") String createdAt) {
        // Expecting format: "2025-05-01T00:00:00"
        LocalDateTime dateTime = LocalDateTime.parse(createdAt);
        return purchaseService.getPurchasesByCreatedAt(dateTime);
    }
}
