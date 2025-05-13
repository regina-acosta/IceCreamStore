package com.example.icecream.service;

import com.example.icecream.model.Flavor;
import com.example.icecream.repository.FlavorRepository;
import com.example.icecream.util.FlavorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlavorService {

    private static final long MAX_FLAVORS = 125;
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

    public List<Flavor> getFlavorsByStatus(FlavorStatus status) {
        return flavorRepository.findByStatus(status);
    }

    public Flavor saveFlavor(Flavor flavor) {
        long flavorCount = flavorRepository.countByStatus(FlavorStatus.ACTIVE);
        if (flavorCount >= MAX_FLAVORS) {
            throw new IllegalStateException("Cannot add more than " + MAX_FLAVORS + " flavors.");
        }
        return flavorRepository.save(flavor);
    }

}

