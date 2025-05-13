package com.example.icecream.repository;

import com.example.icecream.model.Flavor;
import com.example.icecream.util.FlavorStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlavorRepository extends JpaRepository<Flavor, UUID> {

    public Optional<Flavor> findById(UUID id);
    public List<Flavor> findAll();
    public Optional<Flavor> findByFlavorName(String flavorName);
    public List<Flavor> findByStatus(FlavorStatus status);

}
