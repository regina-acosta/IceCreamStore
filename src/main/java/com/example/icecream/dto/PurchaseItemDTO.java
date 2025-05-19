package com.example.icecream.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class PurchaseItemDTO {
    private UUID id;
    private FlavorDTO flavor;
    private int quantity;

    // Constructors
    public PurchaseItemDTO() {}

    public PurchaseItemDTO(UUID id, FlavorDTO flavor, int quantity) {
        this.id = id;
        this.flavor = flavor;
        this.quantity = quantity;

    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "PurchaseItemDTO{" +
                "id=" + id +
                ", flavor=" +  flavor +
                ", quantity=" + quantity +
                '}';
    }

}
