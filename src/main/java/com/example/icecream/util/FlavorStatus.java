package com.example.icecream.util;

public enum FlavorStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String status;

    FlavorStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
