package com.example.icecream.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Min(value = 0)
    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    public Purchase() {
        this.createdAt = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    public Purchase(double price, Customer Customer) {
        this();
        this.totalPrice = price;
        this.createdAt = LocalDateTime.now();
        this.customer = customer;

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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
