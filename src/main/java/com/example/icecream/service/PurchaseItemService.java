package com.example.icecream.service;

import com.example.icecream.model.PurchaseItem;
import com.example.icecream.repository.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchaseItemService {

    private final PurchaseItemRepository purchaseItemRepository;

    @Autowired
    public PurchaseItemService(PurchaseItemRepository purchaseItemRepository) {
        this.purchaseItemRepository = purchaseItemRepository;
    }

    public Optional<PurchaseItem> getPurchaseItemById(UUID id) {
        return purchaseItemRepository.findById(id);
    }

    public List<PurchaseItem> getAllPurchaseItems() {
        return purchaseItemRepository.findAll();
    }

    public List<PurchaseItem> getPurchaseItemsByFlavorName(String flavorName) {
        return purchaseItemRepository.findByFlavor_FlavorName(flavorName);
    }

    public Optional<PurchaseItem> getPurchaseItemByFlavorId(UUID flavorId) {
        return purchaseItemRepository.findByFlavor_Id(flavorId);
    }
    public PurchaseItem savePurchaseItem(PurchaseItem item) {
        return purchaseItemRepository.save(item);
    }

    /**
     * Count total purchase quantity for a specific flavor within a date range.
     *
     * @param flavorId UUID of the flavor
     * @param startDate start of the date range
     * @param endDate end of the date range
     * @return List of Object arrays containing: [flavorId, flavorName, totalPurchases]
     */
    public List<Object[]> countTotalPurchasesPerMonth(UUID flavorId, LocalDateTime startDate, LocalDateTime endDate) {
        return purchaseItemRepository.countTotalPurchasesPerMonth(flavorId, startDate, endDate);
    }
}

