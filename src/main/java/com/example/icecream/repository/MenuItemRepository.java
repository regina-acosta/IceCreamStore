package com.example.icecream.repository;

import com.example.icecream.model.MenuItem;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {

    public List<MenuItem> findAll();
    public Optional<MenuItem> findById(UUID id);
    public List<MenuItem> findByMenuMonth(int month);
    public List<MenuItem> findByMenuYear(int year);
    public List<MenuItem> findByMenuMonthAndMenuYear(int month, int year);
    public List<MenuItem> findByFlavor_Id(UUID id);
    public List<MenuItem> findByFlavor_FlavorName(String flavorName);

    List<MenuItem> findByMenuMonthAndMenuYearAndRankScoreBetween(@Min(value = 1) @Max(value = 12) int menuMonth, int menuYear,
                                                                 double rankScoreAfter, double rankScoreBefore);

}
