package com.example.icecream.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.UUID;

@Entity
@Table(name = "purchase_item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"purchase_id", "flavor_id"})
})
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY) // many purchase items can have the same flavor
    @JoinColumn(name = "flavor_id", nullable = false)
    private Flavor flavor;

    @Min(value = 0, message = "Quantity must be at least 0")
    @Column(nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    public PurchaseItem() {
        this.id = UUID.randomUUID();
    }
    public PurchaseItem(Purchase purchase, Flavor flavor, int quantity, double unitPrice) {
        this();
        this.purchase = purchase;
        this.flavor = flavor;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }


    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
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

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
