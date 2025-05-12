package com.example.icecream.controller;

import com.example.icecream.model.Flavor;
import com.example.icecream.service.FlavorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ResponseEntity<Flavor> createFlavor(@RequestBody Flavor flavor) {
        try {
            Flavor savedFlavor = flavorService.saveFlavor(flavor);
            return ResponseEntity.ok(savedFlavor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
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
    public List<Flavor> getFlavorsByStatus(@PathVariable String status) {
        return flavorService.getFlavorsByStatus(status);
    }

}

