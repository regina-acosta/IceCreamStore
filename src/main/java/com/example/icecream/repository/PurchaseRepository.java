package com.example.icecream.repository;

import com.example.icecream.entity.Flavor;
import com.example.icecream.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

    public Optional<Purchase> findById(UUID id);
    public List<Purchase> findAll();
    public List<Purchase> findByCustomer_Id(UUID customerId);
    public List<Purchase> findByCreatedAt(LocalDateTime createdAt);
}
