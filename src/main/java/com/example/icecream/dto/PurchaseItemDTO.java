package com.example.icecream.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class PurchaseItemDTO {
    private UUID id;
    private LocalDateTime createdAt;
    private FlavorDTO flavor;
    private int quantity;
    private Double unitPrice;

    // Constructors
    public PurchaseItemDTO() {}

    public PurchaseItemDTO(UUID id, LocalDateTime createdAt, FlavorDTO flavor, int quantity, Double unitPrice) {
        this.id = id;
        this.createdAt = createdAt;
        this.flavor = flavor;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public FlavorDTO getFlavor() {
        return flavor;
    }

    public void setFlavor(FlavorDTO flavor) {
        this.flavor = flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "PurchaseItemDTO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", flavor=" +  flavor +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
