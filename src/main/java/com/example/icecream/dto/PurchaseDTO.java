package com.example.icecream.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PurchaseDTO {
    private UUID id;
    private LocalDateTime createdAt;
    private Double totalPrice;
    private CustomerDTO customerDTO;
    private List<PurchaseItemDTO> purchaseItems;

    // Constructors
    public PurchaseDTO() {}

    public PurchaseDTO(UUID id, LocalDateTime createdAt, Double totalPrice, CustomerDTO customerDTO, List<PurchaseItemDTO> purchaseItems) {
        this.id = id;
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
        this.customerDTO = customerDTO;
        this.purchaseItems = purchaseItems;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomerDTO getCustomerId() {
        return customerDTO;
    }

    public void setCustomerId(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItemDTO> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", totalPrice=" + totalPrice +
                ", CustomerDTO=" + customerDTO +
                ", purchaseItems=" + purchaseItems +
                '}';
    }
}
