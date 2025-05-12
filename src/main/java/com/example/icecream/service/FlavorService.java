package com.example.icecream.service;

import com.example.icecream.entity.Flavor;
import com.example.icecream.repository.FlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlavorService {

    private final FlavorRepository flavorRepository;

    @Autowired
    public FlavorService(FlavorRepository flavorRepository) {
        this.flavorRepository = flavorRepository;
    }

    public Optional<Flavor> getFlavorById(UUID id) {
        return flavorRepository.findById(id);
    }

    public List<Flavor> getAllFlavors() {
        return flavorRepository.findAll();
    }

    public Optional<Flavor> getFlavorByName(String flavorName) {
        return flavorRepository.findByFlavorName(flavorName);
    }

    public List<Flavor> getFlavorsByStatus(String status) {
        return flavorRepository.findByStatus(status);
    }

    public Flavor saveFlavor(Flavor flavor) {
        return flavorRepository.save(flavor);
    }

}

