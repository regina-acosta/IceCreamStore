package com.example.icecream.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vote", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customer_id", "flavor_id", "vote_month", "vote_year"})
})
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY) // multiple votes are associated with a single customer
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY) // multiple votes are associated with a single flavor
    @JoinColumn(name = "flavor_id", nullable = false)
    private Flavor flavor;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Min(value = 1)
    @Max(value = 12)
    @Column(name = "vote_month", nullable = false)
    private int voteMonth;

    @Column(name = "vote_year", nullable = false)
    private int voteYear;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getVoteMonth() {
        return voteMonth;
    }

    public void setVoteMonth(int voteMonth) {
        this.voteMonth = voteMonth;
    }

    public int getVoteYear() {
        return voteYear;
    }

    public void setVoteYear(int voteYear) {
        this.voteYear = voteYear;
    }
}
