package com.example.icecream.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CreatePurchaseRequest {
    private UUID customerId;
    private List<PurchaseItemRequest> purchaseItems;
    private BigDecimal totalPrice;

    // Constructors
    public CreatePurchaseRequest() {}

    public CreatePurchaseRequest(UUID customerId, List<PurchaseItemRequest> purchaseItems, BigDecimal totalPrice) {
        this.customerId = customerId;
        this.purchaseItems = purchaseItems;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public List<PurchaseItemRequest> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItemRequest> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CreatePurchaseRequest{" +
                "customerId=" + customerId +
                ", purchaseItems=" + purchaseItems +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
