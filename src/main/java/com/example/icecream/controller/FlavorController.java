package com.example.icecream.controller;

import com.example.icecream.model.Customer;
import com.example.icecream.model.Flavor;
import com.example.icecream.service.FlavorService;
import com.example.icecream.util.FlavorStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/flavors")
public class FlavorController {

    private final FlavorService flavorService;

    @Autowired
    public FlavorController(FlavorService flavorService) {
        this.flavorService = flavorService;
    }

    // Create a new falvor
    record CreateFlavorPayload(
            @NotEmpty(message = "Flavor name is required")
            String flavorName,
            String description) {}

    @PostMapping
    public ResponseEntity<?> createFlavor(@Valid @RequestBody CreateFlavorPayload payload) {
        try {
            var newFlavor = new Flavor();
            newFlavor.setFlavorName(payload.flavorName());
            newFlavor.setDescription(payload.description());

            Flavor savedFlavor = flavorService.saveFlavor(newFlavor);
            return new ResponseEntity<>(savedFlavor, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flavor> getFlavorById(@PathVariable UUID id) {
        return flavorService.getFlavorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Flavor> getAllFlavors() {
        return flavorService.getAllFlavors();
    }

    @GetMapping("/name/{flavorName}")
    public ResponseEntity<Flavor> getFlavorByName(@PathVariable String flavorName) {
        return flavorService.getFlavorByName(flavorName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public List<Flavor> getFlavorsByStatus(@PathVariable FlavorStatus status) {
        return flavorService.getFlavorsByStatus(status);
    }

}

