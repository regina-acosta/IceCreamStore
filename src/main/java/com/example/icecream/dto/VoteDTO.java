package com.example.icecream.dto;

import java.util.UUID;

public class VoteDTO {

    private UUID id;
    private UUID customerId;
    private UUID flavorId; // assuming votes are on menu items
    private int month;
    private int year;

    public VoteDTO() {}

    public VoteDTO(UUID id, UUID customerId, UUID flavorId, int month, int year) {
        this.id = id;
        this.customerId = customerId;
        this.flavorId = flavorId;
        this.month = month;
        this.year = year;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getFlavorId() {
        return flavorId;
    }

    public void setFlavorId(UUID flavorId) {
        this.flavorId = flavorId;
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

}
