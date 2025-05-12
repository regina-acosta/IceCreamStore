package com.example.icecream.repository;

import com.example.icecream.model.MonthlyMenuItem;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MonthlyMenuItemRepository extends JpaRepository<MonthlyMenuItem, UUID> {

    public List<MonthlyMenuItem> findAll();
    public Optional<MonthlyMenuItem> findById(UUID id);
    public List<MonthlyMenuItem> findByMenuMonth(int month);
    public List<MonthlyMenuItem> findByMenuYear(int year);
    public List<MonthlyMenuItem> findByMenuMonthAndMenuYear(int month, int year);
    public List<MonthlyMenuItem> findByFlavor_Id(UUID id);
    public List<MonthlyMenuItem> findByFlavor_FlavorName(String flavorName);

    List<MonthlyMenuItem> findByMenuMonthAndMenuYearAndRankScoreBetween(@Min(value = 1) @Max(value = 12) int menuMonth, int menuYear,
                                                                        @Min(value = 1) @Max(value = 125) int rankScoreAfter, @Min(value = 1) @Max(value = 125) int rankScoreBefore);

}
