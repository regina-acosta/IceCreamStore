package com.example.icecream.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "flavor")
public class Flavor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "flavor_name", nullable = false, length = 100, unique = true)
    private String flavorName;
    private String description;
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Flavor() {
        this.createdAt = LocalDateTime.now();
        this.id = UUID.randomUUID();

    }

    public Flavor(String flavorName, String description, String status) {
        this();
        this.flavorName = flavorName;
        this.description = description;
        this.status = status;

    }

    public UUID getId() {
        return id;
    }


    public String getFlavorName() {
        return flavorName;
    }

    public void setFlavorName(String flavorName) {
        this.flavorName = flavorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
