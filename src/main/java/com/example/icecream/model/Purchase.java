package com.example.icecream.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "purchase", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customer_id"})
})
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false) // Many purchases for one customer
    private Customer customer;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Min(value = 0)
    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseItem> purchaseItems = new ArrayList<>();

    // PrePersist for Timestamps
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters

    public UUID getId() {
        return id;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void addPurchaseItem(PurchaseItem item) {
        item.setPurchase(this); // Set the purchase reference in the item
        this.purchaseItems.add(item);
    }
    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCreatedAt(LocalDateTime now) {
    }

    public void setPurchaseItems(List<PurchaseItem> items) {
        this.purchaseItems = items;
    }
}
