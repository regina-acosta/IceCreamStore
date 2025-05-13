package com.example.icecream.service;

import com.example.icecream.dto.CreatePurchaseRequest;
import com.example.icecream.dto.PurchaseItemRequest;
import com.example.icecream.model.Customer;
import com.example.icecream.model.Flavor;
import com.example.icecream.model.Purchase;
import com.example.icecream.model.PurchaseItem;
import com.example.icecream.repository.CustomerRepository;
import com.example.icecream.repository.FlavorRepository;
import com.example.icecream.repository.PurchaseItemRepository;
import com.example.icecream.repository.PurchaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;
    private final FlavorRepository flavorRepository;
    private final PurchaseItemRepository purchaseItemRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository,
                           CustomerRepository customerRepository,
                           FlavorRepository flavorRepository,
                           PurchaseItemRepository purchaseItemRepository) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
        this.flavorRepository = flavorRepository;
        this.purchaseItemRepository = purchaseItemRepository;
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
    @Transactional
    public Purchase createPurchase(CreatePurchaseRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);

        List<PurchaseItem> items = new ArrayList<>();
        double total = 0.0;

        for (PurchaseItemRequest itemRequest : request.getPurchaseItems()) {
            Flavor flavor = flavorRepository.findById(itemRequest.getFlavorId())
                    .orElseThrow(() -> new IllegalArgumentException("Flavor not found"));

            PurchaseItem item = new PurchaseItem();
            item.setFlavor(flavor);
            item.setQuantity(itemRequest.getQuantity());
            item.setUnitPrice(itemRequest.getUnitPrice());
            total += item.getQuantity() * item.getUnitPrice();

            items.add(item);
        }

        purchase.setTotalPrice(total);

        for (PurchaseItem item : items) {
            item.setPurchase(purchase); // Set purchase for each item
        }
        purchase.setPurchaseItems(items);

        // Save purchase (cascades not assumed, so save both)
        purchase = purchaseRepository.save(purchase);

        return purchase;
    }
    //TODO: Implement method to get purchases by date range

}

