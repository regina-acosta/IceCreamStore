package com.example.icecream.controller;

import com.example.icecream.dto.CreatePurchaseRequest;
import com.example.icecream.dto.PurchaseDTO;
import com.example.icecream.model.Purchase;
import com.example.icecream.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.icecream.util.PurchaseUtil.getPurchaseDTO;
import static com.example.icecream.util.PurchaseUtil.getPurchaseDTOList;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody @Valid CreatePurchaseRequest request) {
        try{
            Purchase saved = purchaseService.createPurchase(request);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);

        }catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> getAllPurchases() {
        try {
            List<Purchase> purchases = purchaseService.getAllPurchases();
            // Fetch all purchases from the service
            List<PurchaseDTO> purchaseDTOs = getPurchaseDTOList(purchases);
            return ResponseEntity.ok(purchaseDTOs);
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDTO> getPurchaseById(@PathVariable UUID id) {
        Optional<Purchase> purchase = purchaseService.getPurchaseById(id);
        if(purchase.isPresent()) {
            try{
                PurchaseDTO p = getPurchaseDTO(purchase.get());
                return ResponseEntity.ok(p);
            }catch (Exception e) {
                return ResponseEntity.status(500).body(null);
            }

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PurchaseDTO>> getPurchasesByCustomerId(@PathVariable UUID customerId) {
        try {
            // Fetch purchases by customer ID from the service
            List<Purchase> purchases = purchaseService.getPurchasesByCustomerId(customerId);
            List<PurchaseDTO> purchaseDTOs = getPurchaseDTOList(purchases);
            return ResponseEntity.ok(purchaseDTOs);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/date")
    public ResponseEntity<List<PurchaseDTO>> getPurchasesByCreatedAt(@RequestParam("createdAt") String createdAt) {
        try {
            // Parse the createdAt string to LocalDateTime
            LocalDateTime dateTime = LocalDateTime.parse(createdAt);
            List<Purchase> purchases = purchaseService.getPurchasesByCreatedAt(dateTime);

            // Convert each Purchase entity to a PurchaseDTO
            List<PurchaseDTO> purchaseDTOs = getPurchaseDTOList(purchases);

            return ResponseEntity.ok(purchaseDTOs);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
