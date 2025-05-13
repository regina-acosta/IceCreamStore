package com.example.icecream.dto;

import com.example.icecream.model.Flavor;
import com.example.icecream.util.FlavorStatus;

import java.util.UUID;

public class FlavorDTO {
    private UUID id;
    private String name;
    private FlavorStatus status;
    private String description;

    // Constructors
    public FlavorDTO() {}

    public FlavorDTO(UUID id,
                     String name,
                     FlavorStatus status,
                     String description) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    @Override
    public String toString() {
        return "FlavorDTO{" +
                "id=" + id +
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
}

