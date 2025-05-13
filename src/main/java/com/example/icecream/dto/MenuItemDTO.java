package com.example.icecream.dto;

import com.example.icecream.model.MenuItem;

import java.util.UUID;

public class MenuItemDTO {

    private UUID id;
    private int month;
    private int year;
    private Double unitPrice;
    private Double rankScore;
    private FlavorDTO flavor;

    public MenuItemDTO() {
    }

    public MenuItemDTO(UUID id, FlavorDTO flavor, int month) {
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

    public static MenuItemDTO fromEntity(MenuItem entity) {
        MenuItemDTO dto = new MenuItemDTO();
        dto.setId(entity.getId());
        dto.setMonth(entity.getMonth());
        dto.setYear(entity.getYear());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setRankScore(entity.getRankScore());
        dto.setFlavor(FlavorDTO.fromEntity(entity.getFlavor()));
        return dto;
    }

    private void setRankScore(Double rankScore) {
        this.rankScore = rankScore;
    }

    private void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }
    public Double getRankScore() {
        return rankScore;
    }
    public MenuItem toEntity() {
        MenuItem entity = new MenuItem();
        entity.setId(this.id);
        entity.setMonth(this.month);
        entity.setYear(this.year);
        entity.setUnitPrice(this.unitPrice);
        entity.setRankScore(this.rankScore);
        // You still need to manually set the Flavor entity when saving
        return entity;
    }
}

