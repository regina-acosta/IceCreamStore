package com.example.icecream.controller;

import com.example.icecream.model.PurchaseItem;
import com.example.icecream.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchase-items")
public class PurchaseItemController {

    private final PurchaseItemService purchaseItemService;

    @Autowired
    public PurchaseItemController(PurchaseItemService purchaseItemService) {
        this.purchaseItemService = purchaseItemService;
    }

    @GetMapping
    public List<PurchaseItem> getAllPurchaseItems() {
        return purchaseItemService.getAllPurchaseItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseItem> getPurchaseItemById(@PathVariable UUID id) {
        Optional<PurchaseItem> item = purchaseItemService.getPurchaseItemById(id);
        return item.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/flavor/{flavorId}")
    public ResponseEntity<PurchaseItem> getPurchaseItemByFlavorId(@PathVariable UUID flavorId) {
        Optional<PurchaseItem> item = purchaseItemService.getPurchaseItemByFlavorId(flavorId);
        return item.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/flavor-name/{flavorName}")
    public List<PurchaseItem> getPurchaseItemsByFlavorName(@PathVariable String flavorName) {
        return purchaseItemService.getPurchaseItemsByFlavorName(flavorName);
    }

    @PostMapping
    public ResponseEntity<PurchaseItem> savePurchaseItem(@RequestBody PurchaseItem item) {
        PurchaseItem saved = purchaseItemService.savePurchaseItem(item);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/summary")
    public List<Object[]> countTotalPurchasesPerMonth(
            @RequestParam UUID flavorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        return purchaseItemService.countTotalPurchasesPerMonth(flavorId, startDate, endDate);
    }
}
