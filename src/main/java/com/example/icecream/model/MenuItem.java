package com.example.icecream.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "menu_item", uniqueConstraints = {
@UniqueConstraint(columnNames = {"flavor_id", "menu_month", "menu_year"})
})
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Min(value = 1)
    @Max(value = 12)
    @Column(name = "menu_month", nullable = false)
    private int menuMonth;

    @Column(name = "menu_year", nullable = false)
    private int menuYear;

    @ManyToOne(fetch = FetchType.LAZY) // multiple menus are associated with a single flavor
    @JoinColumn(name = "flavor_id", nullable = false)
    private Flavor flavor;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "rank_score", nullable = false)
    private Double rankScore;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // PrePersist for Timestamps
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }


    public int getMonth() {
        return menuMonth;
    }

    public void setMonth(int month) {
        this.menuMonth = month;
    }

    public int getYear() {
        return menuYear;
    }

    public void setYear(int year) {
        this.menuYear = year;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public Double getUnitPrice() {
        return unitPrice;

    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Double getRankScore() {
        return rankScore;
    }
    public void setRankScore(Double rankScore) {
        this.rankScore = rankScore;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
