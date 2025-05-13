package com.example.icecream.dto;

import java.util.UUID;

public class PurchaseItemRequest {
    private UUID flavorId;
    private int quantity;
    private Double unitPrice;

    // Constructors
    public PurchaseItemRequest() {}

    public PurchaseItemRequest(UUID flavorId, int quantity, Double unitPrice) {
        this.flavorId = flavorId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public UUID getFlavorId() {
        return flavorId;
    }

    public void setFlavorId(UUID flavorId) {
        this.flavorId = flavorId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "PurchaseItemRequest{" +
                "flavorId=" + flavorId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

