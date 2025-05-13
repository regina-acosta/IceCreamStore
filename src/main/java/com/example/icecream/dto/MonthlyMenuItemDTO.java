package com.example.icecream.dto;

import com.example.icecream.model.Flavor;
import com.example.icecream.model.MonthlyMenuItem;

import java.util.UUID;

public class MonthlyMenuItemDTO {

    private UUID id;
    private int month;
    private int year;
    private long unitPrice;
    private int rankScore;
    private FlavorDTO flavor;

    public MonthlyMenuItemDTO() {
    }

    public MonthlyMenuItemDTO(UUID id, FlavorDTO flavor, int month) {
        this.id = id;
        this.flavor = flavor;
        this.month = month;
    }

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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // --- Mapping Methods ---

    public static MonthlyMenuItemDTO fromEntity(MonthlyMenuItem entity) {
        MonthlyMenuItemDTO dto = new MonthlyMenuItemDTO();
        dto.setId(entity.getId());
        dto.setMonth(entity.getMonth());
        dto.setYear(entity.getYear());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setRankScore(entity.getRankScore());
        dto.setFlavor(FlavorDTO.fromEntity(entity.getFlavor()));
        return dto;
    }

    private void setRankScore(int rankScore) {
        this.rankScore = rankScore;
    }

    private void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getUnitPrice() {
        return unitPrice;
    }
    public int getRankScore() {
        return rankScore;
    }
    public MonthlyMenuItem toEntity() {
        MonthlyMenuItem entity = new MonthlyMenuItem();
        entity.setId(this.id);
        entity.setMonth(this.month);
        entity.setYear(this.year);
        entity.setUnitPrice(this.unitPrice);
        entity.setRankScore(this.rankScore);
        // You still need to manually set the Flavor entity when saving
        return entity;
    }
}

