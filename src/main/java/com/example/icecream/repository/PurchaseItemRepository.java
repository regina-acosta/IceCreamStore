package com.example.icecream.repository;

import com.example.icecream.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, UUID> {


    public Optional<PurchaseItem> findById(UUID id);
    public List<PurchaseItem> findAll();
    public List<PurchaseItem> findByFlavor_FlavorName(String flavorName);
    public Optional<PurchaseItem> findByFlavor_Id(UUID id);

    // count total purchase items that month for a given flavor
    @Query("SELECT p.flavor.id, p.flavor.flavorName, COUNT(p.quantity) as total_purchases " +
            "FROM PurchaseItem p " +
            "WHERE p.purchase.createdAt BETWEEN :startDate AND :endDate " +
            "AND p.flavor.id = :flavorId " +
            "GROUP BY p.flavor.id " +
            "ORDER BY COUNT(p.quantity) DESC")
    List<Object[]> countTotalPurchasesPerMonth(@Param("flavorId") UUID flavorId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
