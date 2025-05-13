package com.example.icecream.dto;

import com.example.icecream.model.Flavor;
import com.example.icecream.util.FlavorStatus;

import java.util.UUID;

public class FlavorDTO {
    private UUID id;
    private String name;
    private FlavorStatus status;
    private String description;
    private Double unitPrice;

    // Constructors
    public FlavorDTO() {}

    public FlavorDTO(UUID id,
                     String name,
                     FlavorStatus status,
                     String description) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "FlavorDTO{" +
                "id=" + id +
                ", unitPrice=" + unitPrice +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // Convert Flavor entity to DTO
    public static FlavorDTO fromEntity(Flavor flavor) {
        FlavorDTO dto = new FlavorDTO();
        dto.setId(flavor.getId());
        dto.setFlavorName(flavor.getFlavorName());
        dto.setDescription(flavor.getDescription());
        dto.setStatus(flavor.getStatus());
        dto.setUnitPrice(flavor.getUnitPrice());
        return dto;
    }

    private void setStatus(FlavorStatus status) {
    this.status = status;}

    private void setDescription(String description) {
    this.description = description;}

    private void setFlavorName(String flavorName) {
        this.name = flavorName;
    }

    public FlavorStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
    public String getFlavorName() {
        return name;
    }

    public void setFlavor(Flavor flavor) {
        this.name = flavor.getFlavorName();
        this.status = flavor.getStatus();
        this.description = flavor.getDescription();
        this.unitPrice = flavor.getUnitPrice();
    }

}

